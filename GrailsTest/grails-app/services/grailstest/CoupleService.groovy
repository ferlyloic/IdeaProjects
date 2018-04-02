package grailstest

import grails.gorm.services.Service

@Service(Couple)
interface CoupleService {

    Couple get(Serializable id)

    List<Couple> list(Map args)

    Long count()

    void delete(Serializable id)

    Couple save(Couple couple)

}