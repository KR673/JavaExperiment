package com.wxb.commontest.activiti;

import com.wxb.commontest.SpringBootStartApplicationTest;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ActivitiTest extends SpringBootStartApplicationTest {

    @Autowired
    private ProcessEngine processEngine;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private HistoryService historyService;

    /**
     * @Description: find all process by definded
     * @Author: WangXiaoBo
     * @Date: 2020/7/1
     */
    @Test
    public void findProcessDefinition() throws Exception {
        List<ProcessDefinition> list = processEngine.getRepositoryService()//与流程定义和部署对象相关的Service
                .createProcessDefinitionQuery()//创建一个流程定义的查询
                /**指定查询条件,where条件*/
//                        .deploymentId(deploymentId)//使用部署对象ID查询
//                        .processDefinitionId(processDefinitionId)//使用流程定义ID查询
//                        .processDefinitionKey(processDefinitionKey)//使用流程定义的key查询
//                        .processDefinitionNameLike(processDefinitionNameLike)//使用流程定义的名称模糊查询

                /**排序*/
                .orderByProcessDefinitionVersion().asc()//按照版本的升序排列
//                        .orderByProcessDefinitionName().desc()//按照流程定义的名称降序排列

                /**返回的结果集*/
                .list();//返回一个集合列表，封装流程定义
//                        .singleResult();//返回惟一结果集
//                        .count();//返回结果集数量
//                        .listPage(firstResult, maxResults);//分页查询
        if(list!=null && list.size()>0){
            for(ProcessDefinition pd:list){
                System.out.println("流程定义ID:"+pd.getId());//流程定义的key+版本+随机生成数
                System.out.println("流程定义的名称:"+pd.getName());//对应hello.bpmn文件中的name属性值
                System.out.println("流程定义的key:"+pd.getKey());//对应hello.bpmn文件中的id属性值
                System.out.println("流程定义的版本:"+pd.getVersion());//当流程定义的key值相同的相同下，版本升级，默认1
                System.out.println("资源名称bpmn文件:"+pd.getResourceName());
                System.out.println("资源名称png文件:"+pd.getDiagramResourceName());
                System.out.println("部署对象ID："+pd.getDeploymentId());
                System.out.println("*********************************************");
            }
        }
    }

    /**
     * 启动流程实例
     */
    @Test
    public void startProcessInstance(){
        //1、流程定义的key，通过这个key来启动流程实例
        String processDefinitionKey = "leave";
        //2、与正在执行的流程实例和执行对象相关的Service
        // startProcessInstanceByKey方法还可以设置其他的参数，比如流程变量。
        ProcessInstance pi = processEngine.getRuntimeService()
                .startProcessInstanceByKey(processDefinitionKey);//使用流程定义的key启动流程实例，key对应helloworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
        System.out.println("流程实例ID:"+pi.getId());//流程实例ID
        System.out.println("流程定义ID:"+pi.getProcessDefinitionId());//流程定义ID
    }
    /**
     * 查询当前人的个人任务
     */
    @Test
    public void findPersonalTask(){
        String assignee = "wxb";
        List<Task> list = taskService//与正在执行的任务管理相关的Service
                .createTaskQuery()//创建任务查询对象
                /**查询条件（where部分）*/
                .taskAssignee(assignee)//指定个人任务查询，指定办理人
//                        .taskCandidateUser(candidateUser)//组任务的办理人查询
//                        .processDefinitionId(processDefinitionId)//使用流程定义ID查询
//                        .processInstanceId(processInstanceId)//使用流程实例ID查询
//                        .executionId(executionId)//使用执行对象ID查询
                /**排序*/
                .orderByTaskCreateTime().asc()//使用创建时间的升序排列
                /**返回结果集*/
//                        .singleResult()//返回惟一结果集
//                        .count()//返回结果集的数量
//                        .listPage(firstResult, maxResults);//分页查询
                .list();//返回列表
        if(list!=null && list.size()>0){
            for(Task task:list){
                System.out.println("任务ID:"+task.getId());
                System.out.println("任务名称:"+task.getName());
                System.out.println("任务的创建时间:"+task.getCreateTime());
                System.out.println("任务的办理人:"+task.getAssignee());
                System.out.println("流程实例ID："+task.getProcessInstanceId());
                System.out.println("执行对象ID:"+task.getExecutionId());
                System.out.println("流程定义ID:"+task.getProcessDefinitionId());
                System.out.println("********************************************");
            }
        }
    }
}
