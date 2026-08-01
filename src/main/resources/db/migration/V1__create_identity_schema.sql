-- =====================================================
-- V1 - Identity Schema
-- Description: Creates the identity module tables.
-- =====================================================

-- =====================================================
-- USERS
-- =====================================================

CREATE TABLE users
(
    id BIGINT GENERATED ALWAYS AS IDENTITY,

    first_name VARCHAR(100) NOT NULL,

    last_name VARCHAR(100) NOT NULL,

    email VARCHAR(150) NOT NULL,

    phone_number VARCHAR(25),

    password VARCHAR(255) NOT NULL,

    enabled BOOLEAN NOT NULL DEFAULT TRUE,

    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT pk_users PRIMARY KEY (id),

    CONSTRAINT uq_users_email UNIQUE (email)
);

CREATE INDEX idx_users_email
    ON users(email);

-- =====================================================
-- ROLES
-- =====================================================

CREATE TABLE roles
(
    id BIGINT GENERATED ALWAYS AS IDENTITY,

    name VARCHAR(50) NOT NULL,

    description VARCHAR(255),

    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT pk_roles PRIMARY KEY (id),

    CONSTRAINT uq_roles_name UNIQUE (name)
);

-- =====================================================
-- USER_ROLES
-- =====================================================

CREATE TABLE user_roles
(
    user_id BIGINT NOT NULL,

    role_id BIGINT NOT NULL,

    CONSTRAINT pk_user_roles
        PRIMARY KEY (user_id, role_id),

    CONSTRAINT fk_user_roles_user
        FOREIGN KEY (user_id)
            REFERENCES users(id)
            ON DELETE CASCADE,

    CONSTRAINT fk_user_roles_role
        FOREIGN KEY (role_id)
            REFERENCES roles(id)
            ON DELETE CASCADE
);

CREATE INDEX idx_user_roles_role
    ON user_roles(role_id);

-- =====================================================
-- INITIAL ROLES
-- =====================================================

INSERT INTO roles(name, description)
VALUES
    ('ROLE_ADMIN', 'System administrator'),
    ('ROLE_ORGANIZER', 'Event organizer'),
    ('ROLE_CUSTOMER', 'Application customer');