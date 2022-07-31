package io.github.ewertonpontini.rest

import io.github.ewertonpontini.rest.domain.User
import io.github.ewertonpontini.rest.dto.CreateUserRequest
import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import io.quarkus.hibernate.orm.panache.PanacheQuery
import io.quarkus.logging.Log
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

        Log.debug("Eai como vai"+query.count())

        return Response.ok("30").build()
    }
}