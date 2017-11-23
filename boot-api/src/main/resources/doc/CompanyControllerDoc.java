package cn.voctrals.boot.api.doc;

/**
 * Created by liulei on 16/11/2016.
 */
public interface AreaControllerDoc {
    /**
     *
     * @api {get} /companies/{id} 获取公司详情
     *
     * @apiName getCompanyInfo
     *
     * @apiGroup Company
     *
     * @apiVersion 0.1.0
     *
     * @apiDescription 根据公司ID获取公司详细
     *
     * @apiUse common_authorization
     *
     * @apiParam {String} id 公司ID
     *
     * @apiUse common_success
     *
     * @apiSuccess {String} data.id 公司ID
     * @apiSuccess {String} data.companyName 公司名
     * @apiSuccess {String} data.companyLogo 公司LOGO
     * @apiSuccess {String} data.companyFinancingFace 融资阶段
     * @apiSuccess {String} data.companyFinancingFaceName 融资阶段名
     * @apiSuccess {String} data.companyIndustry 公司行业
     * @apiSuccess {String} data.companyIndustryName 公司行业名
     * @apiSuccess {String} data.companyScale 公司规模
     * @apiSuccess {String} data.companyScaleName 公司规模名
     * @apiSuccess {String} data.companyDescription 公司描述
     * @apiSuccess {String} data.companyAddress 公司地址
     * @apiSuccess {String} data.companyWebsite 公司网址
     *
     * @apiSuccess {Object[]} data.companyEnvironmentList 公司环境
     * @apiSuccess {String} data.companyEnvironmentList.id 公司环境附件ID
     * @apiSuccess {String} data.companyEnvironmentList.seq 公司环境附件顺序
     * @apiSuccess {String} data.companyEnvironmentList.attachmentUrl 公司环境附件链接
     * @apiSuccess {String} data.companyEnvironmentList.attachmentName 公司环境附件名称
     *
     * @apiSuccess {Object[]} data.companyTags 公司标签
     * @apiSuccess {String} data.companyTags.tagTypeId 标签ID
     * @apiSuccess {String} data.companyTags.tagTypeName 标签名
     *
     *
     * @apiSuccessExample Success-Response(CompanyInfoDto):

    {
    "data": {
    "id": "58529b71391f47ca9eb9c57f039f137c",
    "companyName": "大连安家帮网络科技有限公司",
    "companyLogo": "http://ogzl05bw9.bkt.clouddn.com/logo.png",
    "companyFinancingFace": "03",
    "companyFinancingFaceName": "C轮",
    "companyIndustry": "2",
    "companyIndustryName": "计算机",
    "companyScale": "1",
    "companyScaleName": "20-50人",
    "companyDescription": "一家神奇的公司",
    "companyAddress": "高新街",
    "companyWebsite": "http://www.anjiabang.co",
    "companyEnvironmentList": [
    {
    "id": "1",
    "seq": 1,
    "attachmentUrl": "aaa",
    "attachmentName": "aaa"
    },
    {
    "id": "2",
    "seq": 2,
    "attachmentUrl": "bbb",
    "attachmentName": "bbb"
    },
    {
    "id": "3",
    "seq": 3,
    "attachmentUrl": "ccc",
    "attachmentName": "ccc"
    }
    ],
    "companyTags": [
    {
    "tagTypeId": "aad1e82747f84548b7dc457eb9b06461",
    "tagTypeName": "美女如云"
    },
    {
    "tagTypeId": "8012ef554968432ba8aaa1124731c7b1",
    "tagTypeName": "免费零食"
    },
    {
    "tagTypeId": "90ed6de7075e4640b2d0eea1191add1f",
    "tagTypeName": "高大上"
    }
    ]
    }
    }

     * @apiUse common_error
     */
    void getCompanyInfo();

    /**
     * @api {get} /companies/jobs/{id} 获取公司所有职位
     *
     * @apiName getAllJobs
     *
     * @apiGroup Company
     *
     * @apiVersion 0.1.0
     *
     * @apiDescription 根据公司ID获取所有的职位
     *
     * @apiUse common_authorization
     *
     * @apiParam {String} id 公司ID
     *
     * @apiUse common_success
     *
     * @apiSuccessExample Success-Response(JobDto):

    {
    "data": [
    {
    "id": "1",
    "jobName": "软件工程师",
    "jobSalaryName": "2000以下",
    "jobRequireDegreeName": "本科",
    "jobExpName": "1~3年",
    "jobCityName": "大连市",
    "checkPoint": [
    "团队协作",
    "学习能力",
    "抗压力",
    "职位能力高级",
    "职位能力中级",
    "职位能力初级"
    ]
    },
    {
    "id": "2",
    "jobName": "测试工程师",
    "jobSalaryName": "2000以下",
    "jobRequireDegreeName": "本科",
    "jobExpName": "1~3年",
    "jobCityName": "大连市",
    "checkPoint": [
    "稳定性",
    "团队协作",
    "职位能力高级",
    "职位能力中级"
    ]
    },
    {
    "id": "3",
    "jobName": "测试工程师",
    "jobSalaryName": "2000以下",
    "jobRequireDegreeName": "本科",
    "jobExpName": "1~3年",
    "jobCityName": "大连市",
    "checkPoint": [
    "学习能力",
    "抗压力",
    "职位能力高级",
    "职位能力中级"
    ]
    }
    ]
    }

     * @apiUse common_error
     */
    void getAllJobs();

    /**
     * @api {get} /companies/feedback/{id}?page={page}&limit={limit} 获取公司所有职位反馈
     *
     * @apiName getCompanyFeedback
     *
     * @apiGroup Company
     *
     * @apiVersion 0.1.0
     *
     * @apiDescription 根据公司ID获取职位反馈
     *
     * @apiUse common_authorization
     *
     * @apiParam {String} id 公司ID
     * @apiParam {Integer} page 显示第几页（1开始）
     * @apiParam {Integer} limit 每页显示多少条（默认5条）
     *
     * @apiSuccess {String} data.id ID
     * @apiSuccess {String} data.applicantAccountId 用户融云ID
     * @apiSuccess {String} data.applicantNickName 用户名
     * @apiSuccess {String} data.jobName 职位名称
     * @apiSuccess {String} data.applicantFeedback 反馈内容
     * @apiSuccess {String} data.companyFeedbackPoint 公司评分
     *
     * @apiSuccess {Object[]} data.applicantJobTagList 评价标签
     * @apiSuccess {String} data.applicantJobTagList.id 唯一标识，前端没有意义
     * @apiSuccess {String} data.applicantJobTagList.tagTypeId 评价标签ID
     * @apiSuccess {String} data.applicantJobTagList.tagTypeName 评价标签名
     *
     * @apiSuccessExample Success-Response(ApplicantJobDto):

    {
    "data": [
    {
    "id": "2",
    "applicantAccountId": "b49c2d13aa854378a58cebe06daacb29",
    "applicantNickName": "hudc22",
    "applicantHead": "1234",
    "jobName": "测试工程师",
    "applicantFeedback": "1",
    "applicantJobTagList": [
    {
    "id": "2_1b2a2c8ef4414c029675d68655793b7f",
    "tagTypeId": "1b2a2c8ef4414c029675d68655793b7f",
    "tagTypeName": "我也帖"
    },
    {
    "id": "2_7d293d168aa54f29bd2965955af4cc5d",
    "tagTypeId": "7d293d168aa54f29bd2965955af4cc5d",
    "tagTypeName": "环境优雅"
    },
    {
    "id": "2_b9cb0c0e57a5423f9b29d1d83cfdb376",
    "tagTypeId": "b9cb0c0e57a5423f9b29d1d83cfdb376",
    "tagTypeName": "面试时间短"
    },
    {
    "id": "2_c9812f3eab654546a23d6d8e26332083",
    "tagTypeId": "c9812f3eab654546a23d6d8e26332083",
    "tagTypeName": "面试顺利"
    },
    {
    "id": "2_d7339afdd5ec4db49866000221e23f2e",
    "tagTypeId": "d7339afdd5ec4db49866000221e23f2e",
    "tagTypeName": "贴着婉儿"
    }
    ],
    "companyFeedbackPoint": "2"
    }
    ]
    }

     * @apiUse common_error
     */
    void getCompanyFeedback();
}
