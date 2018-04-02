package grailstest

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DailyReportServiceSpec extends Specification {

    DailyReportService dailyReportService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new DailyReport(...).save(flush: true, failOnError: true)
        //new DailyReport(...).save(flush: true, failOnError: true)
        //DailyReport dailyReport = new DailyReport(...).save(flush: true, failOnError: true)
        //new DailyReport(...).save(flush: true, failOnError: true)
        //new DailyReport(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //dailyReport.id
    }

    void "test get"() {
        setupData()

        expect:
        dailyReportService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<DailyReport> dailyReportList = dailyReportService.list(max: 2, offset: 2)

        then:
        dailyReportList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        dailyReportService.count() == 5
    }

    void "test delete"() {
        Long dailyReportId = setupData()

        expect:
        dailyReportService.count() == 5

        when:
        dailyReportService.delete(dailyReportId)
        sessionFactory.currentSession.flush()

        then:
        dailyReportService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        DailyReport dailyReport = new DailyReport()
        dailyReportService.save(dailyReport)

        then:
        dailyReport.id != null
    }
}
