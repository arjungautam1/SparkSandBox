/**
 * @author :arjun
 * Project :SparkCRUD
 * Date : 2020-12-18
 * Time : 12:00
 */
package user.controller;

import com.google.gson.Gson;
import user.model.User;
import user.service.UserService;
import user.service.UserServiceMapImpl;
import user.status.StandardResponse;
import user.status.StatusResponse;

import static spark.Spark.*;

public class SparkREST {
    public static void main(String[] args) {

        final UserService userService = new UserServiceMapImpl();


        /*Add User*/
        post("/users", (request, response) -> {
            response.type("application/json");

            User user = new Gson().fromJson(request.body(), User.class);

            userService.addUser(user);
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

        /*Get Users*/
        get("/users", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(userService.getUsers())));
        });

        /*Get User*/
        get("/users/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(userService.getUser(request.params(":id")))));
        });

        put("/users/:id", ((request, response) -> {
            response.type("application/json");

            User toEdit = new Gson().fromJson(request.body(), User.class);
            User editedUser = userService.editUser(toEdit);

            if (editedUser != null) {
                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(editedUser)));
            } else {
                return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, new Gson().toJsonTree("User not found or error in edit")));
            }
        }));

        delete("/users/:id", (request, response) -> {
            response.type("application/json");

            userService.deleteUser(request.params(":id"));
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "User deleted"));
        });

        options("/users/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, (userService.userExist(request.params(":id"))) ? "User Exists" : "User does not exists"));
        });
    }
}
