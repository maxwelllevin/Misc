using System;
using System.Collections.Generic;
using System.Collections;
using System.Text;

namespace BankingLedger
{
    class Program
    {

        private static Hashtable users;
        private static User active;
        private static List<string> actions;
        private static string command;

        
        /// <summary>
        /// Initializes the users and actions variables.
        /// </summary>
        private static void InitVariables()
        {
            users = new Hashtable();
            actions = LoggedOutActions();
        }

        /// <summary>
        /// The list of actions a user can take while logged out.
        /// </summary>
        /// <returns>Returns a list of actions (strings).</returns>
        private static List<string> LoggedOutActions()
        {
            List<string> avail = new List<string>();
            avail.Add("login");
            avail.Add("create account");
            avail.Add("quit");
            return avail;
        }

        /// <summary>
        /// The list of actions a user can take while logged in.
        /// </summary>
        /// <returns>Returns a list of actions (strings).</returns>
        private static List<string> LoggedInActions()
        {
            List<string> avail = new List<string>();
            avail.Add("balance");
            avail.Add("history");
            avail.Add("deposit");
            avail.Add("withdraw");
            avail.Add("logout");
            avail.Add("quit");
            return avail;
        }      


        /// <summary>
        /// Prompts the user to take an action from the list of available actions. Does not require user's choice to be in the available actions.
        /// </summary>
        /// <returns>Returns false if the action requested is 'quit', true otherwise.</returns>
        private static bool ReadLineNotQuit()
        {
            Console.WriteLine("What action would you like to take?");
            foreach (string action in actions)
            {
                Console.WriteLine("\t" + action);
            }
            Console.WriteLine();
            command = Console.ReadLine();
            while (!actions.Contains(command))
            {
                Console.WriteLine($"Error: {command} is not a valid action. Please choose one of the following actions:");
                foreach (string action in actions)
                {
                    Console.WriteLine("\t" + action);
                }
                Console.WriteLine();
                command = Console.ReadLine();
            }
            return command != "quit";
        }

        /// <summary>
        /// Handles the entry of a password from the console. Places '*' instead of password characters as the user types.
        /// Borrowed from https://stackoverflow.com/questions/3404421/password-masking-console-application
        /// </summary>
        /// <returns></returns>
        private static string GetPassword()
        {
            var pwd = new StringBuilder();
            while (true)
            {
                ConsoleKeyInfo i = Console.ReadKey(true);
                if (i.Key == ConsoleKey.Enter)
                {
                    break;
                }
                else if (i.Key == ConsoleKey.Backspace)
                {
                    if (pwd.Length > 0)
                    {
                        pwd.Remove(pwd.Length - 1, 1);
                        Console.Write("\b \b");
                    }
                }
                else if (i.KeyChar != '\u0000') // KeyChar == '\u0000' if the key pressed does not correspond to a printable character, e.g. F1, Pause-Break, etc
                {
                    pwd.Append(i.KeyChar);
                    Console.Write("*");
                }
            }
            Console.WriteLine();
            return pwd.ToString();
        }

        /// <summary>
        /// Prompts the user to create a new account.
        /// </summary>
        private static void CreateAccount()
        {
            // Prompt user for a username and password.
            Console.Write("Please enter your username: ");
            string username = Console.ReadLine();
            while (users.ContainsKey(username))  // If the username is taken
            {
                Console.WriteLine("Error: that username is already taken. Please enter a new one.");
                username = Console.ReadLine();
            }
            Console.Write("Please enter your password: ");
            //string password = Console.ReadLine();
            string password = GetPassword();

            // Make the new user and log them in.
            User newUser = new User(username, password.GetHashCode());
            users.Add(username, newUser);
            active = newUser;
            actions = LoggedInActions();
            Console.WriteLine("\n");
            Console.WriteLine("---------------------------------------------------");
            Console.WriteLine($"Successfully logged in user: {active.username}.");
            Console.WriteLine("---------------------------------------------------");
        }

        /// <summary>
        /// Prompts the user to log in.
        /// </summary>
        private static void Login()
        {
            Console.Write("Please enter your username: ");
            string username = Console.ReadLine();
            Console.Write("Please enter your password: ");
            string password = GetPassword();

            if (users.ContainsKey(username)) // Username is valid
            {
                if (((User) users[username]).PasswordMatches(password.GetHashCode()))  // Password matches for given username
                {
                    active = (User) users[username];
                    actions = LoggedInActions();
                    Console.WriteLine("\n");
                    Console.WriteLine("---------------------------------------------------");
                    Console.WriteLine($"Successfully logged in user: {active.username}.");
                    Console.WriteLine("---------------------------------------------------");
                    return;
                }
            }
            Console.WriteLine("Error: Invalid username or password.\n");
        }

        /// <summary>
        /// Prints the account balance for the active user.
        /// </summary>
        public static void Balance()
        {
            Console.WriteLine($"{active.username}, you have ${active.GetBalance()}.\n");
        }

        /// <summary>
        /// Prints the account history for the active user.
        /// </summary>
        public static void History()
        {
            Console.WriteLine(active.GetTransactionsString());
        }

        /// <summary>
        /// Prompts the active user to deposit money to their account.
        /// </summary>
        public static void Deposit()
        {
            Console.WriteLine("How much would you like to deposit?");
            string input = Console.ReadLine();
            try
            {
                double value = Convert.ToDouble(input);
                if (value < 0)
                {
                    Console.WriteLine("Error: Please enter a positive value to deposit.");
                }
                else
                {
                    active.Deposit(value);
                }
            }
            catch (Exception)
            {
                Console.WriteLine($"Error: {input} is not a number. Please enter a number.\n");
            }
            Console.WriteLine();
        }

        /// <summary>
        /// Prompts the user to withdraw from their account.
        /// </summary>
        public static void Withdraw()
        {
            Console.WriteLine("How much would you like to withdraw?");
            string input = Console.ReadLine();
            try
            {
                double value = Convert.ToDouble(input);
                if (value < 0)
                {
                    Console.WriteLine("Error: Please enter a positive value to withdraw.");
                }
                else if (value > active.GetBalance())
                {
                    Console.WriteLine($"Error: You do not have sufficient funds to withdraw ${value}");
                }
                else
                {
                    active.Withdraw(value);
                }
                
            }
            catch (Exception)
            {
                Console.WriteLine($"Error: {input} is not a number. Please enter a number.");
            }
            Console.WriteLine();
        }
        
        
        /// <summary>
        /// Logs the active user out and resets the available actions.
        /// </summary>
        private static void Logout()
        {
            Console.WriteLine($"Successfully logged out user: {active.username}.\n");
            active = null;
            actions = LoggedOutActions();

        }


        static void Main(string[] args)
        {
            InitVariables();

            Console.WriteLine("Banking Ledger");
            Console.WriteLine();

            // Program loop
            while (ReadLineNotQuit())
            {             
                switch (command)
                {
                    case "login":
                        Login();
                        break;

                    case "create account":
                        CreateAccount();
                        break;

                    case "balance":
                        Balance();
                        break;

                    case "history":
                        History();
                        break;

                    case "deposit":
                        Deposit();
                        break;

                    case "withdraw":
                        Withdraw();
                        break;

                    case "logout":
                        Logout();
                        break;
                }

            }

        }
    }
}
