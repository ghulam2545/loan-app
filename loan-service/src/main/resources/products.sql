CREATE TABLE IF NOT EXISTS products (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(1000),
    category VARCHAR(50) NOT NULL,
    interest_rate NUMERIC,
    max_loan_amount INTEGER,
    active BOOLEAN NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL
);

INSERT INTO products (id, name, description, category, interest_rate, max_loan_amount, active, created_at, updated_at)
VALUES
    ('P1', 'Home Loan', 'Loan for purchasing residential property.', 'HOME_LOAN', 7.5, 5000000, TRUE, '2025-06-28', '2025-06-28'),

    ('P2', 'Personal Loan', 'Unsecured loan for personal needs.', 'HOME_LOAN', 12.0, 1000000, TRUE, '2025-06-27', '2025-06-28'),

    ('P3', 'Car Loan', 'Loan for purchasing a car.', 'HOME_LOAN', 9.0, 2000000, TRUE, '2025-06-26', '2025-06-28'),

    ('P4', 'Credit Card Platinum', 'Premium credit card product.', 'HOME_LOAN', 24.0, NULL, TRUE, '2025-06-25', '2025-06-28'),

    ('P5', 'Fixed Deposit', 'Secure investment with fixed returns.', 'HOME_LOAN', 6.0, NULL, TRUE, '2025-06-24', '2025-06-28');
