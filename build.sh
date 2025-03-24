#!/bin/bash
set -e

PROJECT_DIR="./Grim/"

# Check if the project directory exists
if [ ! -d "$PROJECT_DIR" ]; then
  echo "Error: Project directory $PROJECT_DIR not found. Please ensure the Grim directory exists in the same directory as the script."
  exit 1
fi

# Change directory to the project directory
cd "$PROJECT_DIR"
echo "Changing directory to project directory: $PROJECT_DIR..."

echo "Starting project build process..."

# Check for Gradle Wrapper (gradlew) and run Gradle build
if [ -f "./gradlew" ]; then
  echo "Gradle Wrapper (gradlew) found. Starting Gradle build..."
  ./gradlew build
  BUILD_COMMAND="Gradle"
else
  echo "Error: Gradle Wrapper (gradlew) not found in the project directory. Please ensure the project is a Gradle project and has the gradlew file."
  exit 1
fi

# Check the build status of the last command
BUILD_STATUS=$?

if [ "$BUILD_STATUS" -eq 0 ]; then
  echo "Project build completed successfully."
else
  echo "Error: Project build with $BUILD_COMMAND failed. Please check the build logs for errors."
  exit 1
fi

echo "Build process finished."
