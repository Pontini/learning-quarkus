package io.github.ewertonpontini.rest.domain

import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import javax.persistence.*

@Entity
@Table(name = "users")
class User : PanacheEntityBase() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "age")
    var age: Int? = null

}