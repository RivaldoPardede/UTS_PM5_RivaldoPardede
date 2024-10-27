package com.example.netwise.data

object QuestionsRepository {
    val questionList: List<Question> = listOf (
        Question (
            id = 1,
            text = "What does ARP Spoofing aim to achieve in a network?",
            options = listOf (
                "Disguise malicious packets as legitimate data",
                "Redirect network traffic to a rogue device",
                "Encrypt network packets for security",
                "Identify all devices connected to a network"
            ),
            correctAnswerIndex = 1
        ),
        Question (
            id = 2,
            text = "What encryption standard is considered the most secure among the options below?",
            options = listOf (
                "WEP",
                "WPA",
                "WPA2",
                "ARP"
            ),
            correctAnswerIndex = 2
        ),
        Question (
            id = 3,
            text = "Which technique involves intercepting data between a sender and receiver without their knowledge?",
            options = listOf (
                "ARP Spoofing",
                "DNS Spoofing",
                "Man-In-The-Middle Attack",
                "MAC Filtering"
            ),
            correctAnswerIndex = 2
        ),
        Question (
            id = 4,
            text = "In a network, what does the term \"sniffing\" mean?",
            options = listOf (
                "Changing the IP address",
                "Blocking malicious packets",
                "Monitoring network traffic for analysis",
                "Connecting to a Wi-Fi network"
            ),
            correctAnswerIndex = 2
        ),
        Question (
            id = 5,
            text = "Which method allows an attacker to access internet traffic by creating a fake Wi-Fi network?",
            options = listOf (
                "WPA Injection",
                "Evil Twin Attack",
                "Man-In-The-Middle Attack",
                "ARP Spoofing"
            ),
            correctAnswerIndex = 1
        ),
        Question (
            id = 6,
            text = "Which of the following is a primary use of ARP in networking?",
            options = listOf (
                "Translating IP addresses into MAC addresses",
                "Filtering network traffic",
                "Encrypting Wi-Fi connections",
                "Establishing a secure VPN"
            ),
            correctAnswerIndex = 0
        ),
        Question (
            id = 7,
            text = "What is one way to discover devices connected to the same network?",
            options = listOf (
                "Use an ARP scan",
                "Decrypt WPA2 encryption",
                "Perform a DNS spoofing attack",
                "Change the router’s password"
            ),
            correctAnswerIndex = 0
        ),
        Question (
            id = 8,
            text = "Which of these attacks can redirect a user to a malicious website by changing DNS entries?",
            options = listOf (
                "Packet Sniffing",
                "ARP Spoofing",
                "DNS Spoofing",
                "Evil Twin Attack"
            ),
            correctAnswerIndex = 2
        ),
        Question (
            id = 9,
            text = "When running a Man-In-The-Middle attack, which type of information can be captured?",
            options = listOf (
                "Only encrypted data",
                "Unencrypted data, including passwords and cookies",
                "Wi-Fi passwords only",
                "Network IP addresses only"
            ),
            correctAnswerIndex = 1
        ),
        Question (
            id = 10,
            text = "To secure a network from attacks, which of the following actions is recommended?",
            options = listOf (
                "Disable WPA2 encryption",
                "Use strong passwords and enable MAC filtering",
                "Allow open access to the Wi-Fi network",
                "Disable router firewall"
            ),
            correctAnswerIndex = 1
        ),

    )
}