
```markdown

# Setting up the web-app locally

1. **Clean Cache:**
   ```bash
   npm cache clean --force
   ```

2. **Start the Application:**
   ```bash
   npm start
   ```
   The application will be accessible at [http://localhost:3000/](http://localhost:3000/).

## Steps to Run the Backend (Spring Boot) Application

1. **Import Project:**
   - Import the project as an existing Maven project into your preferred IDE (e.g., Eclipse, IntelliJ).

2. **Maven Clean:**
   ```bash
   mvn clean
   ```

3. **Maven Install:**
   ```bash
   mvn install
   ```
   After running these commands, the application will start at localhost with the specified port in the `application.properties` file.

   For example, it may start at [http://localhost:8090/](http://localhost:8090/).

## Test the Backend APIs Separately

Use the following URLs to test the backend APIs:

- [http://localhost:8090/leapfinance/gettodolistdata](http://localhost:8090/leapfinance/gettodolistdata) - Get all the to-do tasks.
- [http://localhost:8090/leapfinance/addnewtodotask](http://localhost:8090/leapfinance/addnewtodotask) - Add a new to-do task.
- [http://localhost:8090/leapfinance/edittodotask](http://localhost:8090/leapfinance/edittodotask) - Edit an existing to-do task.
- [http://localhost:8090/leapfinance/deletetask/1](http://localhost:8090/leapfinance/deletetask/1) - Delete a to-do task by ID.

```
