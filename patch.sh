#!/bin/bash
set -e

PATCH_FILE="./patches/paw.patch"
PROJECT_DIR="./Grim/"

# Check if the project directory exists
if [ ! -d "$PROJECT_DIR" ]; then
  echo "Error: Project directory $PROJECT_DIR not found. Please make sure the Grim directory exists in the same directory as the script."
  exit 1
fi

# Check if the patch file exists
if [ ! -f "$PATCH_FILE" ]; then
  echo "Error: Patch file $PATCH_FILE not found. Please make sure paw.patch is in the patches subdirectory."
  exit 1
fi

# Change directory to the project directory
cd "$PROJECT_DIR"
echo "Applying patch $PATCH_FILE to the project in $PROJECT_DIR..."

# Apply the patch using git apply
git apply "../patches/paw.patch"

echo "Patch applied successfully to the project in $PROJECT_DIR."

echo "Done."
