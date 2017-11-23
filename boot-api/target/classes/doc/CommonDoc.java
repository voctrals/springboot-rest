package cn.voctrals.boot.api.doc;

/**
 * Created by liulei on 16/11/2016.
 */
public interface CommonDoc {
    /**
     * @apiDefine result_paginator
     *
     * @apiSuccess {Object} paginator 分页信息
     * @apiSuccess {int} paginator.limit 分页大小
     * @apiSuccess {int} paginator.page 页数
     * @apiSuccess {int} paginator.totalCount 总记录数
     * @apiSuccess {int} paginator.offset 计数从0开始，可以用于mysql分页使用(0-based)
     * @apiSuccess {boolean} paginator.firstPage 是否是首页（第一页），第一页页码为1
     * @apiSuccess {boolean} paginator.lastPage 是否是最后一页
     * @apiSuccess {int} paginator.prePage 上一页
     * @apiSuccess {int} paginator.nextPage 下一页
     * @apiSuccess {boolean} paginator.hasPrePage 是否有上一页
     * @apiSuccess {boolean} paginator.hasNextPage 是否有下一页
     * @apiSuccess {boolean} paginator.startRow 开始行，可以用于oracle分页使用 (1-based)。
     * @apiSuccess {boolean} paginator.endRow 结束行，可以用于oracle分页使用 (1-based)。
     * @apiSuccess {int} paginator.totalPages 总页数
     * @apiSuccess {Integer[]} paginator.slider 页码滑动窗口
     */

    /**
     * @apiDefine common_error
     *
     * @apiError 401 没有权限访问该资源，1.没有提供client_id 2.token失效 3.错误的token
     * @apiError 404 没有找到页面
     * @apiError 405 使用了错误的请求方法
     *
     *
     @apiErrorExample {json} Error-401
    {
        "error": {
            "code": 9004,
            "message": "unauthorized_client"
        }
    }
     @apiErrorExample {json} Error-404
    {
        "timestamp": 1479940312974,
        "status": 404,
        "error": "Not Found",
        "message": "No message available",
        "path": "/boot-api/books1"
    }
     @apiErrorExample {json} Error-405
     {
         "error": {
             "code": 9005,
             "message": "Request method 'POST' not supported; Please use 'GET'"
         }
     }

     *
     *
     */

    /**
     * @apiDefine sample_paginator
     *
     *  "paginator": {
     *     "limit": 2,
     *     "page": 1,
     *     "totalCount": 3,
     *     "offset": 0,
     *     "firstPage": true,
     *     "lastPage": false,
     *     "prePage": 1,
     *     "nextPage": 2,
     *     "hasPrePage": false,
     *     "hasNextPage": true,
     *     "startRow": 1,
     *     "endRow": 2,
     *     "totalPages": 2,
     *     "slider": [
     *       1,
     *       2
     *     ]
     *   }
     */

    /**
     * @apiDefine result_dto_book
     *
     * @apiSuccess {int} data.id ID
     * @apiSuccess {String} data.doubanId 豆瓣ID
     * @apiSuccess {String} data.title 标题
     * @apiSuccess {String} data.url 豆瓣URL
     * @apiSuccess {String} data.description 描述
     */

    /**
     * @apiDefine result_dto_applicant
     *
     * @apiSuccess {Object} data applicant信息
     * @apiSuccess {String} data.id ID
     * @apiSuccess {String} data.accountId 账户ID
     * @apiSuccess {String} data.name 姓名
     * @apiSuccess {String} data.nickName 昵称
     * @apiSuccess {String} data.head 头像
     * @apiSuccess {String} data.sex 性别
     * @apiSuccess {String} data.phone 联系手机
     * @apiSuccess {String} data.email 联系邮箱
     * @apiSuccess {String} data.city 所在城市
     * @apiSuccess {String} data.cityName 所在城市名
     * @apiSuccess {String} data.description 自我描述
     * @apiSuccess {String} data.schoolName 学校名称
     * @apiSuccess {String} data.degree 获得学位
     * @apiSuccess {String} data.degreeName 获得学位名
     * @apiSuccess {String} data.majorId 所学专业
     * @apiSuccess {String} data.majorName 所学专业名
     * @apiSuccess {Date} data.eduStartDate 开始日期
     * @apiSuccess {Date} data.eduEndDate 毕业日期
     * @apiSuccess {String} data.level 求职者级别
     * @apiSuccess {Integer} data.maxPostNum 最大职位投递数
     * @apiSuccess {Integer} data.maxExpectNum 最大意向职位数
     * @apiSuccess {String} data.testFinishFlag 是否已经完成测试（0：否，1：是）
     * @apiSuccess {String} data.retestFlag 是否可以重新测试（0：不可，1：可以）
     * @apiSuccess {String} data.retestLabel 完成测试，未可重新测试，剩余天数
     * @apiSuccess {String} data.expireDays 意向职位过期天数
     * @apiSuccess {String} data.resumePoint 个人简历完成度
     *
     * @apiSuccess {Object[]} data.campusCareerList 求职者校园经历
     * @apiSuccess {String} data.campusCareerList.careerName 活动名称
     * @apiSuccess {String} data.campusCareerList.careerCharacter 活动角色
     * @apiSuccess {Date} data.campusCareerList.careerStartDate 开始日期
     * @apiSuccess {Date} data.campusCareerList.careerEndDate 结束日期
     * @apiSuccess {String} data.campusCareerList.city 城市
     * @apiSuccess {String} data.campusCareerList.cityName 城市名
     * @apiSuccess {String} data.campusCareerList.careerDescription 活动描述
     *
     * @apiSuccess {Object[]} data.languageList 求职者语言能力
     * @apiSuccess {String} data.languageList.languageCode 语言Code
     * @apiSuccess {String} data.languageList.languageName 语言名称
     * @apiSuccess {String} data.languageList.languageLevel 语言级别
     * @apiSuccess {Date} data.languageList.languageLevelName 语言级别名
     * @apiSuccess {Date} data.languageList.languageGivenLevel 评价级别
     * @apiSuccess {Date} data.languageList.languageGivenLevelName 语言级别名
     *
     * @apiSuccess {Object[]} data.careerList 求职者工作经历
     * @apiSuccess {String} data.careerList.careerPart 职位名称
     * @apiSuccess {String} data.careerList.careerCompany 公司名称
     * @apiSuccess {String} data.careerList.careerDescription 工作描述
     * @apiSuccess {Date} data.careerList.careerStartDate 开始日期
     * @apiSuccess {Date} data.careerList.careerEndDate 结束日期
     *
     * @apiSuccess {Object[]} data.expList 求职者项目经验
     * @apiSuccess {String} data.expList.expProjectName 项目名称
     * @apiSuccess {String} data.expList.expProjectJob 项目角色
     * @apiSuccess {String} data.expList.expProjectJobName 项目角色名称
     * @apiSuccess {String} data.expList.expDescription 项目描述
     * @apiSuccess {Date} data.expList.expStartDate 开始日期
     * @apiSuccess {Date} data.expList.expEndDate 结束日期
     */


    /**
     * @apiDefine param_dto_applicant
     *
     * @apiParam {String} accountId 账户ID
     * @apiParam {String} name 姓名
     * @apiParam {String} nickName 昵称
     * @apiParam {String} head 头像
     * @apiParam {String} sex 性别
     * @apiParam {String} phone 联系手机
     * @apiParam {String} email 联系邮箱
     * @apiParam {String} city 所在城市
     * @apiParam {String} description 自我描述
     * @apiParam {String} schoolName 学校名称
     * @apiParam {String} degree 获得学位
     * @apiParam {String} majorId 所学专业
     * @apiParam {Date} eduStartDate 开始日期
     * @apiParam {Date} eduEndDate 毕业日期
     * @apiParam {String} level 求职者级别
     *
     * @apiParam {Object[]} campusCareerList 求职者校园经历
     * @apiParam {String} campusCareerList.careerName 活动名称
     * @apiParam {String} campusCareerList.careerCharacter 活动角色
     * @apiParam {Date} campusCareerList.careerStartDate 开始日期
     * @apiParam {Date} campusCareerList.careerEndDate 结束日期
     * @apiParam {String} campusCareerList.city 城市
     * @apiParam {String} campusCareerList.careerDescription 活动描述
     *
     * @apiParam {Object[]} languageList 求职者语言能力
     * @apiParam {String} languageList.languageCode 语言Code
     * @apiParam {String} languageList.languageLevel 语言级别
     * @apiParam {Date} languageList.languageGivenLevel 评价级别
     *
     * @apiParam {Object[]} careerList 求职者工作经历
     * @apiParam {String} careerList.careerPart 职位名称
     * @apiParam {String} careerList.careerCompany 公司名称
     * @apiParam {String} careerList.careerDescription 工作描述
     * @apiParam {Date} careerList.careerStartDate 开始日期
     * @apiParam {Date} careerList.careerEndDate 结束日期
     *
     * @apiParam {Object[]} expList 求职者项目经验
     * @apiParam {String} expList.expProjectName 项目名称
     * @apiParam {String} expList.expProjectJob 项目角色
     * @apiParam {String} expList.expDescription 项目描述
     * @apiParam {Date} expList.expStartDate 开始日期
     * @apiParam {Date} expList.expEndDate 结束日期
     */

    /**
     * @apiDefine common_success
     *
     * @apiSuccess {Object} error 错误消息说明
     */

    /**
     * @apiDefine common_authorization
     *
     * @apiHeader (Headers) {String} Authorization 访问token  设定规则: "Bearer" + {access_token}
     *
     * @apiHeaderExample {json} Headers-Example:
     * { "Authorization": "Bearer mF_9.B5f-4.1JqM" }
     */


    /**
     * @apiDefine result_dto_SysArea
     *
     * @apiSuccess {Object} data SysArea信息
     * @apiSuccess {String} data.code 省code
     * @apiSuccess {String} data.name 省名称
     * @apiSuccess {Object[]} data.areaList 市列表
     * @apiSuccess {String} data.areaList.code 市code
     * @apiSuccess {String} data.areaList.name 市名称
     *
     */

    /**
     * @apiDefine result_dto_SysDict
     *
     * @apiSuccess {Object} data 字典信息
     * @apiSuccess {String} data.value 键
     * @apiSuccess {String} data.label 内容
     *
     */

    /**
     * @apiDefine result_dto_SysJobTree
     *
     * @apiSuccess {Object} data 职位信息
     * @apiSuccess {String} data.id 职位ID
     * @apiSuccess {String} data.name 职位名
     * @apiSuccess {Object[]} data.jobList 职位列表
     * @apiSuccess {String} data.jobList.id 职位ID
     * @apiSuccess {String} data.jobList.name 职位名
     */

    /**
     * @apiDefine result_SysMajorTreeDto
     *
     * @apiSuccess {Object} data 专业信息
     * @apiSuccess {String} data.id 专业ID
     * @apiSuccess {String} data.name 专业名
     * @apiSuccess {Object[]} data.majorList 专业列表
     * @apiSuccess {String} data.majorList.id 专业ID
     * @apiSuccess {String} data.majorList.name 专业名
     */

    /**
     * @apiDefine result_SysUniversityDto
     *
     * @apiSuccess {Object} data 大学信息
     * @apiSuccess {String} data.code 大学编码
     * @apiSuccess {String} data.name 大学名称
     */

    /**
     * @apiDefine result_JobDto
     *
     * @apiSuccess {Object} data 职位信息
     * @apiSuccess {String} data.id 职位ID
     * @apiSuccess {String} data.companyId 公司ID
     * @apiSuccess {String} data.companyName 公司名称
     * @apiSuccess {String} data.companyLogo 公司LOGO
     * @apiSuccess {String} data.companyScale 公司规模
     * @apiSuccess {String} data.companyScaleName 公司规模名
     * @apiSuccess {String} data.companyFinancingFace 融资阶段
     * @apiSuccess {String} data.companyFinancingFaceName 融资阶段名
     * @apiSuccess {String} data.companyIndustry 公司行业
     * @apiSuccess {String} data.companyIndustryName 公司行业名
     *
     * @apiSuccess {String} data.jobName 职位名称
     * @apiSuccess {String} data.jobRequireDeadline 截止日期
     * @apiSuccess {String} data.jobNature 职位性质
     * @apiSuccess {String} data.jobNatureName 职位性质名
     * @apiSuccess {String} data.jobSalary 薪资范围
     * @apiSuccess {String} data.jobSalaryName 薪资范围名
     * @apiSuccess {String} data.jobRequireDegree 最低学历
     * @apiSuccess {String} data.jobRequireDegreeName 最低学历名
     * @apiSuccess {String} data.jobExp 工作年限
     * @apiSuccess {String} data.jobExpName 工作年限名
     * @apiSuccess {String} data.jobCityCode 工作城市
     * @apiSuccess {String} data.jobCityName 工作城市名
     * @apiSuccess {String} data.jobDistrictCode 工作区域
     * @apiSuccess {String} data.jobDistrictName 工作区域名
     * @apiSuccess {String} data.jobDescription 职位描述
     * @apiSuccess {String} data.jobDepartment 招聘部门
     * @apiSuccess {String} data.jobAddress 工作地址
     * @apiSuccess {String} data.jobLongitude 工作地址经度
     * @apiSuccess {String} data.jobLatitude 工作地址纬度
     *
     * @apiSuccess {Object[]} data.companyTags 公司标签
     * @apiSuccess {String} data.companyTags.tagTypeId 标签ID
     * @apiSuccess {String} data.companyTags.tagTypeName 标签名
     *
     * @apiSuccess {Object[]} data.qualityList 素质重点
     * @apiSuccess {String} data.qualityList.value 素质重点编号
     * @apiSuccess {String} data.qualityList.label 素质重点名
     *
     * @apiSuccess {Object[]} data.abilityList 能力重点
     * @apiSuccess {String} data.abilityList.tagTypeId 能力重点标签ID
     * @apiSuccess {String} data.abilityList.tagTypeName 能力重点标签名
     *
     * @apiSuccess {String[]} data.checkpoint 考核重点
     *
     * @apiSuccess {String} data.jobRecruiterId 招聘人员ID
     * @apiSuccess {String} data.jobRecruiterAccountId 招聘人员融云ID
     * @apiSuccess {String} data.jobRecruiterName 招聘人员名
     * @apiSuccess {String} data.jobRecruiterHead 招聘人员头像
     * @apiSuccess {String} data.jobRecruiterTitle 招聘人员职称
     *
     * @apiSuccess {String} data.matchingDegree 匹配度
     * @apiSuccess {String} data.applyStatus 是否可以在申请（0：是，1：否, 2：不匹配【否】）
     * @apiSuccess {String} data.collected 收藏状态（0：未收藏；1：已收藏）
     *
     */


    /**
     * @apiDefine result_UploadTokenDto
     *
     * @apiSuccess {Object} data 上传凭证DTO
     * @apiSuccess {String} data.token 上传凭证
     * @apiSuccess {String} data.key 上传图片的key（唯一）
     */
}
