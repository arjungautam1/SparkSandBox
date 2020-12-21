import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import service.UserService;

import java.util.List;

import static spark.Spark.*;

/**
 * @author :Arjun Gautam
 * Project :SparkDBConnection
 * Date : 2020-12-21
 * Time : 14:36
 */

public class Main {
    private static UserService userService = new UserService();
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        port(5678);
        get("/user", (request, response) -> {

            List<User> userList = userService.getAllUser();
            return mapper.writeValueAsString(userList);
        });

        get("/user/:id", (request, response) -> {
            int id = Integer.parseInt(request.params(":id"));
            User user = userService.getUserByID(id);
            return mapper.writeValueAsString(user);
        });
        post("/user", (request, response) -> {
            User user = mapper.readValue(request.body(), User.class);
            boolean result = userService.addUser(user);
            return mapper.writeValueAsString(result);

        });


        after(((request, response) -> response.type("application/json")));
    }


}
