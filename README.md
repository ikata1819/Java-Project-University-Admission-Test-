# University Admission Test System

## Introduction

The **University Admission Test System** is a Java-based application designed to streamline and digitize the admission process at Jahangirnagar University. The system offers a centralized platform that serves both students and administrators, making the entire admission process seamless, efficient, and organized.

### For Students:
- **Registration**: Easily register for the university's admission process.
- **Applications**: Submit and track your admission applications.
- **Exam Schedules & Venues**: Access schedules and venue details for exams.
- **Admit Card Downloads**: Download your admit card directly from the system.
- **Final Results**: View your final exam results once they're available.

### For Administrators:
- **Admin Interface**: A secure, password-protected platform that allows administrators to manage student registrations, set schedules and venues, and view student results, enhancing the accuracy and efficiency of the admission process.

The system uses Java's GUI capabilities, such as **Swing** and **AWT**, to offer a modular, user-friendly, and scalable solution for managing university admissions.

## Project Structure / Architecture

### Class Overview:

1. **HomeScreen**:
   - Main entry point of the application.
   - Features menu bars and buttons that link to different sections.
   - Links to the following classes:
     - **Calendar**: Opens the academic calendar for various years.
     - **Calculator and Notebook**: Launches the device’s calculator and notebook applications.
     - **Faculties and Institutes**: Displays information about Jahangirnagar University's faculties and institutes.
     - **Admission**: Navigates to **StudentMenu** for student services.
     - **Manage Admission**: Opens **AdminMenu**, secured with a password.

2. **StudentMenu**:
   - Provides students with access to essential features:
     - **Registration**: Handles student registration.
     - **Application**: Manages the admission application process.
     - **Get Admit Card**: Allows students to download their admit cards.
     - **Exam Schedule and Venue**: Displays exam schedule and venue details.

3. **AdminMenu**:
   - Password-protected section for administrators.
   - Allows administrators to:
     - View registered students.
     - Set exam venues and schedules.
     - View student results.

### Project Features:
- **Home-screen**:
  - Displays options like calendar, faculties & institutes, and student/administrator login.
- **Calendar**:
  - Provides access to academic year calendars.
- **Faculties and Institutions**:
  - Displays detailed information about the university's faculties and institutes.
- **Student Menu**:
  - Includes options like registration, application, admit card download, and schedule/venue details.
- **Admin Menu**:
  - Allows administrators to view registered students, manage exam schedules and venues, and view results.

### Vision and Mission
- **Vision**: To create a modern and efficient admission system that simplifies the process for students while providing administrators with powerful management tools.
- **Mission**: To offer a secure, user-friendly, and comprehensive system that digitizes the entire university admission workflow.

## Installation

To set up this project locally, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/university-admission-test.git
