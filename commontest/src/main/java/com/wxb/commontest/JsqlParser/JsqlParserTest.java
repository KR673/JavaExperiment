package com.wxb.commontest.JsqlParser;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/2/20 21:25
 * @Version: 1.0
 */
public class JsqlParserTest {
    public static void main(String[] args) throws JSQLParserException {
        String sql = "SELECT dd.*,orq.ExamID examId,orq.SubjectID subjectId,orq.ResourceId,orq.DirectoryId,orq.PackageId packageId,orq.PackageType packageType, (select ISNULL(PackageName,'') from ZhongYeLearn.dbo.Package p where p.PackageID=orq.ResourceId)packageName, ISNULL((select top 1 TypeName from ZhongYeLearn.dbo.PackageType pk where pk.TypeId=orq.PackageType and orq.ExamID=pk.ExamId and pk.SiteIndex in (dd.SiteIndex,0) order by pk.SiteIndex desc ),'') packageTypeName FROM ( SELECT ROW_NUMBER () OVER ( partition BY aa.relationUserGroupId ORDER BY po.OrderId DESC ) temp, aa.*,po.SiteIndex,po.OpenDate,po.OrderId FROM (SELECT distinct cj.TableId jiHuiId, cj.RelationUserGroupId relationUserGroupId, cj.Mobile mobile, cj.BanZhuRenUserGroupId banZhuRenId, cj.RelationUserGroupId xueYuanId, cj.CrmHidden isShow, cj.SetBanZhuRenTime, cj.ShiYeBuId FROM ZhongYeLearn.dbo.CRM_JiHui cj inner join ZhongYeLearn.dbo.PaymentOrder po on po.UserGroupId = cj.RelationUserGroupId inner join ZhongYeLearn.dbo.OrderRelation orq on po.OrderId= orq.OrderId LEFT JOIN ZhongYeLearn.dbo.CRM_JiHui_XueGuanShiRelation cjo ON orq.TableId= cjo.OrderRelationId where cj.ShiYeBuId=po.ShiYeBuId and cj.TypeId=2 and cj.ShiYeBuId=41 order by cj.SetBanZhuRenTime desc offset 0 ROWS FETCH NEXT 10 ROWS ONLY) aa inner JOIN ZhongYeLearn.dbo.PaymentOrder po ON po.UserGroupId = aa.relationUserGroupId WHERE aa.ShiYeBuId = po.ShiYeBuId ) dd left JOIN ZhongYeLearn.dbo.OrderRelation orq ON orq.OrderId = dd.OrderId LEFT JOIN ZhongYeLearn.dbo.CRM_JiHui_XueGuanShiRelation cjo ON orq.TableId= cjo.OrderRelationId WHERE temp = 1 order by dd.jiHuiId desc";

        Statement statement = CCJSqlParserUtil.parse(sql);
        TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
        List<String> tableList = tablesNamesFinder.getTableList(statement);



        for (String tableName: tableList) {
            if(tableName.indexOf(".") == -1){
               sql = sql.replaceAll("(?<=\\s|\\,)(" + tableName + "\\b)", "wangxiao.$1");
            }
        }

        System.out.println(sql);

        tableList.stream().forEach(System.out::println);

        Map testMap =  new HashMap(){{
    put("code", 1);
}};
        System.out.println(testMap.get("23"));

    }
}
