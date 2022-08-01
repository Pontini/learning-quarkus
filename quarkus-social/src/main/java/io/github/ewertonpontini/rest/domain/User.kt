package io.github.ewertonpontini.rest.domain

import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import io.quarkus.hibernate.orm.panache.PanacheQuery
import io.quarkus.hibernate.orm.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped
import javax.persistence.*

@Entity
@Table(name = "users")
class User : PanacheEntityBase() {
    companion object {
        fun getAll(): MutableList<User>? {
            return findAll<User>().list()
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "age")
    var age: Int? = null

}
@ApplicationScoped()
class UserRepository: PanacheRepository<User>{
    fun getAll(): PanacheQuery<User>? {
        return findAll()
    }
}