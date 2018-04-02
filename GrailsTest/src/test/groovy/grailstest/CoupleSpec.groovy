package grailstest

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CoupleSpec extends Specification implements DomainUnitTest<Couple> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
