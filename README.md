# NetWise

An Android quiz application focused on foundational network security concepts.

NetWise helps learners practice core cybersecurity topics (for example ARP spoofing, DNS spoofing, MITM, and Wi-Fi security) through an interactive multiple-choice experience with scoring and feedback.

## Table of Contents
- [Overview](#overview)
- [Key Features](#key-features)
- [Screenshots](#screenshots)
- [Demo Video](#demo-video)
- [Design Resources](#design-resources)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Testing](#testing)
- [Roadmap](#roadmap)
- [Contributing](#contributing)
- [Credits](#credits)
- [License](#license)

## Overview
NetWise is built as an educational mobile app for students and beginners who want to assess their understanding of basic network security concepts in a simple and engaging format.

### Learning Scope
- Network fundamentals and attack terminology
- Wi-Fi security standards and common weaknesses
- Defensive best practices and risk awareness

> Note: NetWise is intended for educational use and security awareness training only.

## Key Features
- **User onboarding** with username input before starting a quiz session
- **Interactive quiz flow** with previous/next navigation and submission handling
- **10 curated questions** sourced from an in-app repository
- **Live score tracking** and personalized result message
- **Light/Dark mode toggle** persisted using SharedPreferences
- **Simple Android architecture** suitable for learning and coursework

## Screenshots
<img src="https://github.com/user-attachments/assets/5c65954d-f7c9-4cb0-b654-aebad4e0049d" height="450" alt="Home screen" />
<img src="https://github.com/user-attachments/assets/ac832651-8e15-43c6-93bf-f78f57c24004" height="450" alt="Quiz screen" />

<br />

<img src="https://github.com/user-attachments/assets/52b007fb-426d-49e3-80bf-745c05edc1dd" height="450" alt="Quiz interaction" />
<img src="https://github.com/user-attachments/assets/4bd8dc66-a5fb-4f49-a907-8be62767eba5" height="450" alt="Theme toggle state" />

<br />

<img src="https://github.com/user-attachments/assets/924d9e8b-a612-4147-bb9e-b81af1628071" height="450" alt="Result screen" />
<img src="https://github.com/user-attachments/assets/8442c903-e1fd-4cfb-b8ab-0c051df938b9" height="450" alt="Alternative result screen" />

## Demo Video
https://github.com/user-attachments/assets/a8823081-6fc7-486c-83c6-b899c936addf

## Design Resources
- Mockup: https://www.figma.com/design/vapYVo6AepnxoVzn95zs06/UTS-Prak.Mobile?node-id=0-1&t=yWWUsLXoto8SQq6W-1
- Prototype: https://www.figma.com/proto/vapYVo6AepnxoVzn95zs06/UTS-Prak.Mobile?node-id=7-7&node-type=canvas&t=yWWUsLXoto8SQq6W-0&scaling=scale-down&content-scaling=fixed&page-id=0%3A1&starting-point-node-id=7%3A7&show-proto-sidebar=1

## Tech Stack
- **Language:** Kotlin
- **Build System:** Gradle (Kotlin DSL)
- **Android Gradle Plugin:** 8.7.1
- **Kotlin Plugin:** 1.9.0
- **Target SDK / Compile SDK:** 34
- **Minimum SDK:** 24
- **UI Components:** AndroidX AppCompat, Material Components, ConstraintLayout, RecyclerView, CardView

## Project Structure
```text
UTS/
|- app/
|  |- src/main/java/com/example/netwise/
|  |  |- MainActivity.kt
|  |  |- Quiz.kt
|  |  |- Result.kt
|  |  \- data/
|  |     |- QuestionsModel.kt
|  |     \- QuestionsRepository.kt
|  \- src/main/res/
|- gradle/
|  \- libs.versions.toml
|- build.gradle.kts
\- settings.gradle.kts
```

## Getting Started
### Prerequisites
- Android Studio (recent stable version)
- Android SDK for API 34
- JDK compatible with your Android Gradle Plugin setup

### Run Locally
```powershell
cd "D:\Semester 5\Lab_PM\UTS"
.\gradlew.bat assembleDebug
```

Then open the project in Android Studio and run the `app` configuration on an emulator or physical device.

## Testing
```powershell
cd "D:\Semester 5\Lab_PM\UTS"
.\gradlew.bat test
.\gradlew.bat connectedAndroidTest
```

## Roadmap
- Expand question bank and category grouping
- Add timer-based quiz mode
- Add explanation per answer for learning reinforcement
- Improve state handling to preserve answers across process death

## Contributing
Contributions are welcome for bug fixes, UI improvements, and educational content quality.

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Open a pull request with a clear description

## Credits
- Assets and icons: https://icons8.com/

## License
No license has been declared yet.

If you plan to publish or accept external contributions, add a `LICENSE` file (for example MIT, Apache-2.0, or GPL-3.0).
