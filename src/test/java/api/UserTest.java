package api;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.reqres.config.UsersHttpRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.reqres.dto.request.User;
import org.reqres.dto.response.UserResponseDto;
import org.reqres.dto.response.UsersResponseDto;
import java.util.List;
import java.util.stream.Stream;


public class UserTest {

    private static UsersHttpRequest usersHttpRequest;
    private static User expectedUser;
    private static int pageNumber;


    @BeforeAll
    public static void setUp() {
        usersHttpRequest = new UsersHttpRequest();
        expectedUser = new User(3, "emma.wong@reqres.in", "Emma", "Wong");
        pageNumber = 1;
    }

    @Test
    public void testGetUser() {
        UserResponseDto user = usersHttpRequest.getUserById(3)
                .then()
                .statusCode(200)
                .extract().as(UserResponseDto.class);
        User actualUser = user.getData();
        Assertions.assertEquals(actualUser, expectedUser);
    }

    @Test
    public void checkUserInTheListOnThePage() {
        UsersResponseDto usersList = usersHttpRequest.getUserListByPageNumber(pageNumber)
                .then()
                .statusCode(200)
                .extract().as(UsersResponseDto.class);
        List<User> actualUserList = usersList.getData();
        int actualPage = usersList.getPage();
        Assertions.assertTrue(actualUserList.contains(expectedUser));
        Assertions.assertEquals(pageNumber, actualPage);
    }

    @Test
    public void checkEmailDomainForListUsers() {
        UsersResponseDto usersList = usersHttpRequest.getUserListByPageNumber(pageNumber)
                .then()
                .statusCode(200)
                .extract().as(UsersResponseDto.class);
        List<User> actualUserList = usersList.getData();
        Assertions.assertTrue(actualUserList.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));
    }

    @ParameterizedTest(name = "Are there any users on the page {0} = {1}")
    @MethodSource("getSourceDataForCheckUsersOnThePage")
    public void checkUsersOnThePage(int page, boolean expected) {
        UsersResponseDto usersList = usersHttpRequest.getUserListByPageNumber(page)
                .then()
                .statusCode(200)
                .extract().as(UsersResponseDto.class);
        List<User> actualUsersList = usersList.getData();
        Assertions.assertEquals(expected, !actualUsersList.isEmpty());
    }


    static Stream<Arguments> getSourceDataForCheckUsersOnThePage() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, true),
                Arguments.of(3, false)
        );
    }
}
