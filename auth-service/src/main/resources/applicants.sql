CREATE TABLE IF NOT EXISTS applicants (
      id VARCHAR(255) PRIMARY KEY,
      role VARCHAR(255) NOT NULL,
      status BOOLEAN NOT NULL,
      created_at DATE NOT NULL,
      updated_at DATE NOT NULL,
      first_name VARCHAR(255),
      last_name VARCHAR(255),
      email VARCHAR(255),
      password VARCHAR(255),
      verification_code VARCHAR(255),
      code_expiration DATE NOT NULL
);

INSERT INTO applicants (id, role, status, created_at, updated_at, first_name, last_name, email, password, verification_code, code_expiration)
VALUES ('1', 'APPLICANT', TRUE, '2025-06-28', '2025-06-28', 'Alice', 'Smith', 'alice@example.com', 'pass123', 'ABC123', '2025-07-05');

INSERT INTO applicants (id, role, status, created_at, updated_at, first_name, last_name, email, password, verification_code, code_expiration)
VALUES ('2', 'APPLICANT', TRUE, '2025-06-27', '2025-06-28', 'Bob', 'Johnson', 'bob@example.com', 'pass456', 'DEF456', '2025-07-05');

INSERT INTO applicants (id, role, status, created_at, updated_at, first_name, last_name, email, password, verification_code, code_expiration)
VALUES ('3', 'APPLICANT', FALSE, '2025-06-26', '2025-06-28', 'Carol', 'Williams', 'carol@example.com', 'pass789', 'GHI789', '2025-07-05');

INSERT INTO applicants (id, role, status, created_at, updated_at, first_name, last_name, email, password, verification_code, code_expiration)
VALUES ('4', 'LOAN_OFFICER', TRUE, '2025-06-25', '2025-06-28', 'David', 'Brown', 'david@example.com', 'pass012', 'JKL012', '2025-07-05');

INSERT INTO applicants (id, role, status, created_at, updated_at, first_name, last_name, email, password, verification_code, code_expiration)
VALUES ('5', 'LOAN_OFFICER', TRUE, '2025-06-24', '2025-06-28', 'Eva', 'Davis', 'eva@example.com', 'pass345', 'MNO345', '2025-07-05');
