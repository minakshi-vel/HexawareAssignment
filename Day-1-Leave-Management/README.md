\# Leave Management Backend Module



An enterprise-grade, exception-driven backend component designed to process, validate, and manage corporate employee leave transactions safely.



\## Architecture Highlights

\* \*\*Storage Performance:\*\* Utilizes a `HashMap` for tracking state, achieving $O(1)$ algorithmic runtime efficiency for employee record lookups.

\* \*\*Resilient Flow:\*\* Employs an Exception-Driven architecture where validation vulnerabilities break early using cleanly separated custom execution blocks.

\* \*\*Defensive Engineering:\*\* State structural fields are verified before memory records undergo transactional balance subtractions.



\## Requirements

\* Java 17 or higher

\* Maven 3.6+



\## How to Compile \& Run

1\. Open your terminal at the root directory (`leave-management-backend/`).

2\. Clean and compile the package using Maven:

&#x20;  ```bash

&#x20;  mvn clean compile

