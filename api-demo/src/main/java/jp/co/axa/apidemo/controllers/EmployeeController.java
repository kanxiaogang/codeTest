package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(tags="社員に関するAPIの説明")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    Logger logger = LoggerFactory.getLogger(getClass());

//    Autowiredなので、下記のロジックは不要
//    public void setEmployeeService(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }

    @GetMapping("/employees")
    @ApiOperation(value = "API:社員情報取得",
    			  notes = "<span style='color:red'>ディスクリプション：</span>&nbsp;&nbsp;すべての社員情報を取得する")
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeService.retrieveEmployees();
        logger.info("List<Employee> getEmployees 成功");
        return employees;
    }

    @GetMapping("/employees/{employeeId}")
    @ApiOperation(value = "API:社員情報取得",
	              notes = "<span style='color:red'>ディスクリプション：</span>&nbsp;&nbsp;社員IDにより社員情報を取得する")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="employeeId", value="社員ID", dataType="Long", paramType = "path")
    })
    public Employee getEmployee(@PathVariable(name="employeeId")Long employeeId) {
    	logger.info("Employee getEmployee 成功");
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping("/employees")
    @ApiOperation(value = "API:社員情報追加",
                  notes = "<span style='color:red'>ディスクリプション：</span>&nbsp;&nbsp;社員情報を登録する")
    public void saveEmployee(Employee employee){
        employeeService.saveEmployee(employee);
        logger.info("void saveEmployee 成功");
    }

    @DeleteMapping("/employees/{employeeId}")
    @ApiOperation(value = "API:社員情報削除",
                  notes = "<span style='color:red'>ディスクリプション：</span>&nbsp;&nbsp;社員IDにより社員情報を削除する")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="employeeId", value="社員ID", dataType="Long", paramType = "path")
    })
    public void deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
        employeeService.deleteEmployee(employeeId);
        logger.info("void deleteEmployee 成功");
    }

    @PutMapping("/employees/{employeeId}")
    @ApiOperation(value = "API:社員情報更新",
                  notes = "<span style='color:red'>ディスクリプション：</span>&nbsp;&nbsp;社員情報を更新する")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="employeeId", value="社員ID", dataType="Long", paramType = "path")
    })
    public void updateEmployee(@RequestBody Employee employee,
                               @PathVariable(name="employeeId")Long employeeId){
        Employee emp = employeeService.getEmployee(employeeId);
        if(emp != null){
            employeeService.updateEmployee(employee);
            logger.info("void updateEmployee 成功");
        }else {
        	logger.info("void updateEmployee 失敗");
        }

    }

}
