package io.github.ewertonpontini.rest.domain

import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import io.quarkus.hibernate.orm.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(name = "name")
        val name: String? = null,

        @Column(name = "age")
        val age: Int? = null,
) : PanacheEntityBase()

@ApplicationScoped()
class UserRepository : PanacheRepository<User> {

}