package leukodb3


class User {
    String title
    Gender gender
    String lastname
    String firstname
    String username
    String password
    String email
    Date createdAt
//    Group group
    Boolean active

    static constraints = {
        title(nullable: true, blanc:true, maxSize: 20)
        gender(nullable: false, blank:false)
        lastname(nullable: false, blank:false, maxSize: 100)
        firstname(nullable: false, blank:false, maxSize: 100)
        username(unique: true, nullable: false, blank:false, maxSize: 100)
        password(password:true,nullable: false, blank:false, maxSize: 1000)
        email(email: true ,unique: true, nullable: false, blank:false, maxSize: 1000)
        createdAt( nullable: false, blank: false)

    }
    static mapping = {

    }
}
