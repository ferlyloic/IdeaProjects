package grailstest

import grails.gorm.services.Service

@Service(DailyReport)
interface DailyReportService {

    DailyReport get(Serializable id)

    List<DailyReport> list(Map args)

    Long count()

    void delete(Serializable id)

    DailyReport save(DailyReport dailyReport)

}