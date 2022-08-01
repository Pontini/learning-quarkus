package io.github.ewertonpontini.rest

import io.github.ewertonpontini.rest.domain.UserRepository
import io.github.ewertonpontini.rest.domain.User
import io.github.ewertonpontini.rest.dto.CreateUserRequest
import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response


@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class UserResource {
    @POST
    @Transactional
    fun createUser(data: CreateUserRequest): Response {
        val user = User()
        user.name = data.name
        user.age = data.age
        user.persist()
        return Response.ok(data).build()
    }

    @GET
    fun getListUsers(): Response {
        val result = UserRepository().getAll()?.list<User>()
        return Response.ok(result).build()
    }
}