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
        val user = User(name = data.name, age = data.age)
        user.persist()
        return Response.ok(data).build()
    }

    @GET
    fun getListUsers(): Response {
        val result = UserRepository().findAll().list<User>()
        return Response.ok(result).build()
    }


    @DELETE
    @Transactional
    @Path("{id}")
    fun deleteUser(@PathParam("id") id: Long): Response {
        val user = UserRepository().findById(id)
        if (user != null) {
            user.delete()
            return Response.ok().build()
        }
        return Response.status(Response.Status.NOT_FOUND).build()
    }

    @PUT
    @Path("{id}")
    @Transactional
    fun updateUser(@PathParam("id") id: Long, data: CreateUserRequest): Response {
        val user = UserRepository().findById(id)
        if (user != null) {
            val newUser= user.copy(id = user.id, age = data.age, name = data.name)
            return Response.ok(newUser).build()
        }
        return Response.status(Response.Status.NOT_FOUND).build()
    }
}