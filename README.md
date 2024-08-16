# Jenkins Shared Library

A Jenkins Shared Library is a powerful way to organize and reuse your Jenkins pipeline code across multiple projects. By centralizing common pipeline logic into a shared library, you can enhance code maintainability, reduce duplication, and ensure consistency across different Jenkins jobs. This approach not only saves time but also makes it easier to apply updates or changes to your pipeline logic without needing to modify each pipeline individually.

## Why Use a Jenkins Shared Library?

- **Code Reusability**: Shared libraries allow you to write your pipeline code once and reuse it across multiple Jenkins projects. This reduces redundancy and ensures that all projects follow the same build, test, and deployment processes.

- **Maintainability**: With shared libraries, any update or improvement made to the shared codebase is instantly available to all projects using the library. This makes maintaining and upgrading your CI/CD processes easier and more efficient.

- **Consistency**: By using a shared library, you can enforce consistent practices across all your Jenkins pipelines. This ensures that every project follows the same standards and guidelines, reducing the risk of errors.

- **Scalability**: As your projects grow, managing individual Jenkins pipelines can become cumbersome. A shared library allows you to scale your pipeline management by centralizing common tasks and workflows.

## Structure

The shared library is structured as follows:

```
Jenkins-shared-library/
├── vars/
│ ├── lintApp.groovy
│ ├── testApp.groovy
│ ├── buildJar.groovy
│ ├── packageApp.groovy
│ ├── buildImage.groovy
│ ├── dockerLogin.groovy
│ └── pushImage.groovy
├── src/
│ └── com/example/Docker.groovy
└── README.md
```




### `vars` Folder

The `vars` folder contains Groovy scripts that define global functions. These functions can be used in any Jenkins pipeline by simply calling them by name.

### `src` Folder

The `src` folder contains Groovy classes that can be used to encapsulate logic and provide more structured functionality. The `Docker` class in this folder is designed to manage Docker-related tasks.

### Available Functions

#### 1. `lintApp.groovy`

This function is used to lint your application code, ensuring that it adheres to the defined coding standards and guidelines.

#### 2. `testApp.groovy`

This function runs the test suite for your application. It can be configured to execute unit tests, integration tests, or any other testing framework supported by your project.

#### 3. `buildJar.groovy`

This function is responsible for building a JAR file using your project's build tool (e.g., Gradle or Maven). It ensures that your Java application is compiled and packaged correctly.

#### 4. `packageApp.groovy`

This function packages your application, preparing it for deployment. It can include tasks such as creating archives, setting up environment variables, or any other packaging steps your application requires.

#### 5. `buildImage.groovy`

This function is used to build a Docker image from a Dockerfile in your project. It handles the image building process and can be customized to include additional build steps if needed.

#### 6. `dockerLogin.groovy`

This function handles authentication with your Docker registry, ensuring that the subsequent steps can push Docker images securely.

#### 7. `pushImage.groovy`

This function pushes the Docker image built by `buildImage.groovy` to a specified Docker registry. It ensures that the image is available for deployment.

### `Docker.groovy` Class

The `Docker.groovy` class is a reusable Groovy class that provides methods for building, logging in, and pushing Docker images. It's designed to be used within Jenkins pipelines to streamline Docker-related tasks.


How to Integrate
Clone the Repository: Clone this shared library repository into your Jenkins environment.

Configure Jenkins: In Jenkins, navigate to Manage Jenkins -> Configure System, and add this repository under the Global Pipeline Libraries section.

Use in Pipelines: In your Jenkinsfile, load the shared library using @Library('your-shared-library') _ and call the functions or use the Docker class as demonstrated above.