# BI - Label Detector

This repository contains the **Label Detector** microservice. 

The Data Object microservice can be found here : 

[Go To Data Object](https://github.com/menoudyann/BI_DataObject.git)

## Description

This Java microservice uses Google Cloud Vision API to extract labels from images, offering customizable label limits and confidence thresholds. It outputs concise, JSON-formatted label data.

## Getting Started

### Prerequisites

Here are the prerequisites for finding work on the project.

- IntelliJ IDEA 2023.2.2 (Ultimate Edition)
- Apache Maven 3.9.5 
- Google Cloud Platform account with Vision API V1 enabled 
- Eclipe Temurin version 21.0.1
- jUnit 5.8.1

### Configuration

**Environment File**

The project contains an example of the environment file required for the project. Simply copy it and rename it .env.

```bash
# .env
GOOGLE_APPLICATION_CREDENTIALS="path/to/credentials.json"
```

## Deployment

### On dev environment

#### Dependencies 

Go the the project root and run the following command to install the dependencies.

```
mvn clean install
```
### On prod environment

#### Build

```
mvn clean package
```


## Directory structure

```
./src
├── main
│   ├── java
│   │   └── org
│   │       └── example
│   │           ├── GoogleLabelDetectorImpl.java    //implementation
│   │           ├── ILabelDetector.java             //interface
│   │           ├── Label.java                      //label model
│   │           ├── Main.java
│   │           ├── datas
│   │           │   └── testLabelDetector.jpg
│   │           └── helpers
│   │               └── URLTester.java               //URL tester
│   └── resources
└── test
    └── java
        └── org
            └── example
                └── GoogleLabelDetectorImplTest.java             //test
```



## Collaborate

#### How to propose a new feature ?

If you're interested in enhancing this project, you're welcome to:

- **Fork the Project:** You can create a fork of the project on your own GitHub account to work on your changes.
- **Submit Pull Requests:** If you develop new features or improvements, feel free to submit a pull request for integration into the main project.

#### Commit Rules

I use very simple commit rules. The commit message **starts with an infinitive verb and describes the added/deleted content clearly in one sentence**. If your commit requires two sentences because the code added modifies two things, please make two separate commits. This is to improve readability and also simplify versioning.

#### Branches Strategy

By default, there are two branches: main and develop. Main is the branch currently in production, develop is based on the same branch. 

To add a new feature, please create a branch from develop using Gitflow. [To the Gitflow guide](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow) 

#### Any question ?

For any questions or further information, please feel free to reach out to me at: yann.menoud@gmail.com.



## License

[Choose the license adapted to your project](https://github.com/menoudyann/BI_LabelDetector/blob/main/LICENSE).

## Contact

You can contact me by email at the following address: yann.menoud@gmail.com or directly on [Linkedin](https://www.linkedin.com/in/yann-menoud-433780225/).
