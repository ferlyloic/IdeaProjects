package grailstest

class Couple {
    Person woman
    Person man
    static constraints = {
        id display: true
        woman nullable:true, blank: false, validator: {obj->obj==null? true :obj.gender == Gender.Woman}
        man nullable:true, blank: false, validator: {obj->obj==null? true :obj.gender == Gender.Man}
    }

    @Override
    public String toString() {
        return  this.id +
                ", woman=" + woman +
                ", man=" + man
    }
}
