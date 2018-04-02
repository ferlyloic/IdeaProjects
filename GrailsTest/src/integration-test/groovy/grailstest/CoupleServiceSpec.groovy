package grailstest

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CoupleServiceSpec extends Specification {

    CoupleService coupleService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Couple(...).save(flush: true, failOnError: true)
        //new Couple(...).save(flush: true, failOnError: true)
        //Couple couple = new Couple(...).save(flush: true, failOnError: true)
        //new Couple(...).save(flush: true, failOnError: true)
        //new Couple(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //couple.id
    }

    void "test get"() {
        setupData()

        expect:
        coupleService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Couple> coupleList = coupleService.list(max: 2, offset: 2)

        then:
        coupleList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        coupleService.count() == 5
    }

    void "test delete"() {
        Long coupleId = setupData()

        expect:
        coupleService.count() == 5

        when:
        coupleService.delete(coupleId)
        sessionFactory.currentSession.flush()

        then:
        coupleService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Couple couple = new Couple()
        coupleService.save(couple)

        then:
        couple.id != null
    }
}
