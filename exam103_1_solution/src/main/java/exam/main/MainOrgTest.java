package exam.main;

import exam.base.Loggable;
import exam.base.OrgUnit;
import exam.unit.Department;
import exam.unit.School;
import exam.unit.Staff;
import exam.base.Group;

public class MainOrgTest {
    public static void main(String[] args) {
        testSchool();
        testDepartment();
        testSchoolAsOrgUnit();
        testDepartmentAsOrgUnit();
        testStaff();
        testDepartmentGroup();
    }

    private static void testDepartmentGroup() {
//    6. (10 points) Write a test method named testDepartmentGroup() in the MainOrgTest
//    to test that Group<Department> objects work correctly on append(), find(), remove(),
//    and get() and also use a for loop to access all Department objects in the group.
        Group<Department> dpGroup = new Group<>(10);
        Department dp1 = new Department(1, "KMUTT", new School(1, "IT"));
        Department dp2 = new Department(2, "KMUTT", new School(2, "CS"));
        Department dp3 = new Department(3, "KMUTT", new School(3, "DSI"));
        Department dp4 = new Department(4, "KMUTT", new School(4, "abc"));
        Department dp5 = new Department(5, "KMUTT", new School(5, "def"));
        Department dp6 = new Department(6, "KMUTT", new School(6, "ghi"));
        //append department
        dpGroup.append(dp1);
        dpGroup.append(dp2);
        dpGroup.append(dp3);
        dpGroup.append(dp4);
        dpGroup.append(dp5);
        dpGroup.append(dp6);
        //find department
        System.out.println("find dpGroup 1 : " + dpGroup.find(dp1));
        System.out.println("find dpGroup 2 : " + dpGroup.find(dp2));
        System.out.println("find dpGroup 3 : " + dpGroup.find(dp3));
        System.out.println("find dpGroup 7 : " + dpGroup.find(dp6));
        //remove department
        dpGroup.remove(dp3);
        //get department
        System.out.println("get dpGroup 1 : " + dpGroup.get(0).getSchool().getName());
        System.out.println("get dpGroup 2 : " + dpGroup.get(1).getSchool().getName());
        System.out.println("get dpGroup 3 : " + dpGroup.get(2).getSchool().getName());
        //for loop
        for (int i = 0; i < dpGroup.getSize(); i++) {
            System.out.println("dpGroup "+ i +" : " + dpGroup.get(i).getSchool().getName());
        }

    }
    private static void testStaff() {
        Staff staff = new Staff(1, "John", "Smith", new School(1, "IT"));
        System.out.printf("StaffId: %d%n", staff.getId());
        System.out.printf("StaffFirstname: %s%n", staff.getFirstname());
        System.out.printf("StaffLastname: %s%n", staff.getLastname());
        System.out.printf("StaffAffiliation: %s%n", staff.getAffiliation().getName());
        staff.setId(2);
        staff.setFirstname("KKboy");
        staff.setLastname("GiveMeMoney");
        staff.setAffiliation(new Department(1, "SIT", new School(2, "IT")));
        System.out.printf("StaffId: %d%n", staff.getId());
        System.out.printf("StaffFirstname: %s%n", staff.getFirstname());
        System.out.printf("StaffLastname: %s%n", staff.getLastname());
        System.out.printf("StaffAffiliation: %s%n", staff.getAffiliation().getName());

    }
    private static void testSchool() {
        School school = new School(1, "IT");
        System.out.printf("SchoolCode: %d%n", school.getCode());
        System.out.printf("SchoolName: %s%n", school.getName());
        school.setName("IT-University");
        System.out.printf("SchoolName: %s%n", school.getName());
        System.out.printf("getLog: %s%n", school.getLog());
        school.clearLog();
        System.out.printf("AfterClearlog: %s%n", school.getLog());
        //get Balance
        System.out.printf("SchoolBalance: %f%n", school.getBalance());
        //set Balance earn
        school.earn(10000d);
        System.out.printf("SchoolBalance: %f%n", school.getBalance());
        System.out.printf("getLog: %s%n", school.getLog());

        //set Balance spend
        school.spend(5000d);
        System.out.printf("SchoolBalance: %f%n", school.getBalance());
        System.out.printf("getLog: %s%n", school.getLog());
        school.clearLog();
        System.out.printf("Clearlog: %s%n", school.getLog());

    }
    private static void testDepartment() {
        Department department = new Department(1, "IT", new School(1, "IT"));
        System.out.printf("getCode: %d%n", department.getCode());
        System.out.printf("getName: %s%n", department.getName());
        department.setName("IT-ity");
        System.out.printf("getName: %s%n", department.getName());
        System.out.printf("getLog: %s%n", department.getLog());
        //get school from department
        System.out.printf("getSchool: %s%n", department.getSchool());
        //set school from department
        department.setSchool(new School(2, "SIT"));
        System.out.println(" getName: " + department.getSchool().getName() + " getCode: " + department.getSchool().getCode());
        System.out.printf("getSchool: %s%n", department.getSchool());
        department.clearLog();
        System.out.printf("AfterClearlog: %s%n", department.getLog());
    }
    private static void testSchoolAsOrgUnit() {
//testSchoolAsOrgUnit() tests that School objects work correctly as OrgUnit.
        School school = new School(1, "IT");
        System.out.printf("SchoolCode: %d%n", school.getCode());
        System.out.printf("SchoolName: %s%n", school.getName());
        school.setName("IT-University");
        System.out.printf("SchoolName: %s%n", school.getName());
        System.out.printf("getLog: %s%n", school.getLog());
        school.clearLog();
        System.out.printf("AfterClearlog: %s%n", school.getLog());
        //get Balance
        System.out.printf("SchoolBalance: %f%n", school.getBalance());
        //set Balance earn
        school.earn(10000d);
        System.out.printf("SchoolBalance: %f%n", school.getBalance());
        System.out.printf("getLog: %s%n", school.getLog());

        OrgUnit orgUnit = school;
        System.out.printf("OrgUnitCode: %d%n", orgUnit.getCode());
        System.out.printf("OrgUnitName: %s%n", orgUnit.getName());
        orgUnit.setName("Org-University");
        System.out.printf("OrgUnitName: %s%n", orgUnit.getName());
        System.out.printf("getLog: %s%n", orgUnit.getLog());
        orgUnit.clearLog();
        System.out.printf("AfterClearlog: %s%n", orgUnit.getLog());
        // create org school balance
        System.out.printf("OrgUnitBalance: %.2f%n", ((School)orgUnit).getBalance());
        ((School) orgUnit).earn(10000d);
        System.out.printf("OrgUnitBalance: %.2f%n", ((School)orgUnit).getBalance());
        System.out.printf("getLog: %s%n", orgUnit.getLog());
        ((School) orgUnit).spend(5000d);
        System.out.printf("OrgUnitBalance: %.2f%n", ((School)orgUnit).getBalance());
    }
    private static void testDepartmentAsOrgUnit() {
        Department department = new Department(1, "IT", new School(1, "IT"));
        System.out.printf("getCode: %d%n", department.getCode());
        System.out.printf("getName: %s%n", department.getName());
        department.setName("IT-University");
        System.out.printf("getName: %s%n", department.getName());
        System.out.printf("getLog: %s%n", department.getLog());
        //get school from department
        System.out.printf("getSchool: %s%n", department.getSchool());
        //set school from department
        department.setSchool(new School(2, "SIT"));
        System.out.println(" getName: " + department.getSchool().getName() + " getCode: " + department.getSchool().getCode());
        System.out.printf("getSchool: %s%n", department.getSchool());
        department.clearLog();
        System.out.printf("AfterClearlog: %s%n", department.getLog());
        //testDepartmentAsOrgUnit() tests that Department objects work correctly as OrgUnit.
        Loggable loggable = department;
        System.out.println("getLog : " + loggable.getLog());
        loggable.clearLog();
        System.out.println("clearLog : " + loggable.getLog());
    }

}
