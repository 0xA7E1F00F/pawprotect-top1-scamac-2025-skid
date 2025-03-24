#!/bin/bash
set -e

REPO_DIR="./Grim"
REPO_URL="https://github.com/GrimAnticheat/Grim.git"

echo "Deleting existing local repositories..."
rm -rf "$REPO_DIR"

echo "Cloning repository from $REPO_URL to $REPO_DIR..."
git clone "$REPO_URL" "$REPO_DIR"

echo "Repository successfully recloned."

echo "Cloning complete. You can now apply patches (patch.sh)."
