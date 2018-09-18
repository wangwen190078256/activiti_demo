package test;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class test02 {





	//部署流程
	@Test
	public void test01() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

		processEngine.getRepositoryService().createDeployment().name("报销单审核流程").addClasspathResource("MyProcess.bpmn").addClasspathResource("MyProcess.png").deploy();

	}


	//启动流程
	@Test
	public void test02() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

		processEngine.getRuntimeService().startProcessInstanceByKey("myProcess");

	}


	//根据处理人查询相关的任务
	@Test
	public void test03() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

		List<Task> list=processEngine.getTaskService().createTaskQuery().taskAssignee("黄伟杰").list();
		for (Task task : list) {
			System.out.println("任务ID："+task.getId());//15004
			System.out.println("流程实例ID："+task.getProcessInstanceId());//15001
		}


	}


	//完成任务（狄仁杰）
	@Test
	public void test04() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

		processEngine.getTaskService().complete("15004");//7502


	}

	//完成任务（李元芳）
	@Test
	public void test05() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

		processEngine.getTaskService().complete("17502");


	}

	//根据流程实例ID  查看对应的流程实例
	@Test
	public void test06() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

		ProcessInstance processInstance=processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId("15001").singleResult();
		
		System.out.println(processInstance.getDeploymentId());
		System.out.println(processInstance.getName());
		System.out.println(processInstance.getId());
		
	}

	
	


}
