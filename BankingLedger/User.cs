using System.Collections.Generic;
using System.Text;

namespace BankingLedger
{
    class User
    {
        public readonly string username;
        private readonly int passwordHash;
        private double balance;
        private List<Transaction> transactions;

        /// <summary>
        /// User constructor. 
        /// </summary>
        /// <param name="username">The username for this user.</param>
        /// <param name="passwordHash">The hashed password for this user.</param>
        public User(string username, int passwordHash)
        {
            this.username = username;
            this.passwordHash = passwordHash;
            this.balance = 0;
            this.transactions = new List<Transaction>();
        }

        /// <summary>
        /// Checks to see if the given password matches the user's password.
        /// </summary>
        /// <param name="password">The guessed password.</param>
        /// <returns>Returns true if the passwords match, false otherwise.</returns>
        public bool PasswordMatches(int passwordHash)
        {
            return this.passwordHash == passwordHash;
        }

        /// <summary>
        /// Getter for the account balance.
        /// </summary>
        /// <returns>The account balance.</returns>
        public double GetBalance()
        {
            return this.balance;
        }

        /// <summary>
        /// Getter for the user's transaction history.
        /// </summary>
        /// <returns>Returns a string containing the user's transaction history.</returns>
        public string GetTransactionsString()
        {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.AppendLine("Time\t\t\tType\t\tValue\tBalance");
            foreach (Transaction transaction in transactions)
            {
                stringBuilder.AppendLine(transaction.ToString());
            }
            return stringBuilder.ToString();
        }

        /// <summary>
        /// Attempts to deposit the given value into the account.
        /// </summary>
        /// <param name="value">The amount to deposit. Must be positive.</param>
        public void Deposit(double value)
        {
            if (value < 0)
            {
                throw new System.ArgumentException("Parameter cannot be negative or zero.", "value");
            }
            this.balance += value;
            transactions.Add(new Transaction("deposit", value, this.balance));
        }

        /// <summary>
        /// Attempts to withdraw the given value into the account.
        /// </summary>
        /// <param name="value">The amount to withdraw. Must be positive.</param>
        public void Withdraw(double value)
        {
            if (value < 0)
            {
                throw new System.ArgumentException("Parameter cannot be negative or zero.", "value");
            }
            if (value > this.balance)
            {
                throw new System.ArgumentException("Amount to withdraw cannot exceed account balance.", "value");
            }
            this.balance -= value;
            transactions.Add(new Transaction("withdraw", -1*value, this.balance));
        }
    }
}
