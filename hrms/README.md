# HRMS (Human Resource Management System)
### PostgreSQL - Database
### <a href="hrms.sql">Click</a> for script codes.
* * *
### Relation descriptions : 
  - <b>users</b> <i>(all types of users.)</i>
    - <b>candidates</b> <i>(job seekers)</i>
    - <b>employees</b> <i>(hrms system workers)</i>
    - <b>employers</b> <i>(employers for candidates)</i>
      - <b>employer_activation_by_employees</b> <i>(employers activation method by employees)</i>
  - <b>verification_codes</b> <i>(base table for all activation methods with activation code)</i>
    - <b>verification_code_to_employers</b> <i>(employers acivation method with activation code)</i>
    - <b>verification_code_to_candidates</b> <i>(candidates acivation method with activation code)</i>
  - <b>job_titles</b> <i>(job titles for job positions)</i>
* * *
### ER Diagram with PostgreSQL
<p align="center"><img src="Hrms_ERDiagram.png"></p>
