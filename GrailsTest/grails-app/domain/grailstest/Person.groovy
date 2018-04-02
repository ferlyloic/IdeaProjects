package grailstest

class Person  {
    String vorname
    String nachname
    Gender gender
//    static  belongsTo = ['couple': Couple]
    static constraints = {
        vorname nullable: false, blank: false, unique: true
        nachname nullable: false, blank: false, unique: true
        gender nullable: false, blank: false
    }
    @Override
    public String toString(){
        "$gender $nachname,\t$vorname"
    }
}
