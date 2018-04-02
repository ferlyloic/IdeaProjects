package grailstest

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class DailyReportSpec extends Specification implements DomainUnitTest<DailyReport> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
