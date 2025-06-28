-- auto-generated definition
-- we don't know how to generate root <with-no-name> (class Root) :(

CREATE USER rollmaster WITH PASSWORD 'M3be$0(onM4r(o';

DROP DATABASE rolltogo;

CREATE DATABASE rolltogo
    WITH OWNER = rollmaster
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
GRANT ALL PRIVILEGES ON DATABASE rolltogo TO rollmaster;

--Logearse como rollmaster

\c rolltogo


CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TYPE source_content_enum AS ENUM (
    'ITEM',
    'BACKGROUND',
    'CLASS',
    'SUBCLASS',
    'PROFICIENCIES',
    'BONUSES',
    'ABILITIES',
    'SKILLS',
    'CREATURES',
    'SPELLS',
    'SPECIES',
    'SUBSPECIES',
    'FEATS',
    'LIMITED_USAGES',
    'EFFECTS',
    'ACTIONS',
    'DAMAGES',
    'SENSES',
    'ABILITY_SCORE_IMPROVEMENT',
    'MOVEMENTS',
    'ROOMS'
);

CREATE TYPE visibility_enum AS ENUM (
    'PUBLIC',
    'PRIVATE',
    'UNLISTED'
);

CREATE TYPE item_type_enum AS ENUM (
    'WEAPON',
    'ARMOR',
    'ACCESSORY',
    'CONSUMABLE',
    'TOOL',
    'MISCELLANEOUS'
);

CREATE TYPE rarity_enum AS ENUM (
    'COMMON',
    'UNCOMMON',
    'RARE',
    'VERY_RARE',
    'LEGENDARY',
    'ARTIFACT'
);

CREATE TYPE currency_enum AS ENUM (
    'COPPER',
    'SILVER',
    'GOLD',
    'ELECTRUM',
    'PLATINUM'
);

CREATE TYPE item_modifier_type_enum AS ENUM (
    'BONUS',
    'PENALTY',
    'REDUCTION',
    'TRANSFORMATION'
);

CREATE TYPE cover_type_enum AS ENUM (
    'NONE',
    'HALF',
    'THREE_QUARTERS',
    'FULL'
);

CREATE TYPE spellcasting_progression_enum AS ENUM (
    'FULL_CASTER',
    'HALF_CASTER',
    'THIRD_CASTER',
    'PACT_MAGIC',
    'INNATE_MAGIC'
);

CREATE TYPE ability_type_enum AS ENUM (
    'STRENGTH',
    'DEXTERITY',
    'CONSTITUTION',
    'INTELLIGENCE',
    'WISDOM',
    'CHARISMA',
    'ALL'
);

CREATE TYPE proficiency_type_enum AS ENUM (
    'WEAPON',
    'ARMOR',
    'TOOL',
    'SKILL',
    'SAVING_THROW',
    'LANGUAGE',
    'OTHER'
);

CREATE TYPE bonus_type_enum AS ENUM (
    'ATTACK_ROLL',
    'DAMAGE_ROLL',
    'SAVING_THROW',
    'ABILITY_CHECK',
    'SKILL_CHECK',
    'SPELL_ATTACK_BONUS',
    'INITIATIVE'
);

CREATE TYPE skill_type_enum AS ENUM (
    'ACROBATICS',
    'ANIMAL_HANDLING',
    'ARCANA',
    'ATHLETICS',
    'DECEPTION',
    'HISTORY',
    'INSIGHT',
    'INTIMIDATION',
    'INVESTIGATION',
    'MEDICINE',
    'NATURE',
    'PERCEPTION',
    'PERFORMANCE',
    'PERSUASION',
    'RELIGION',
    'SLEIGHT_OF_HAND',
    'STEALTH',
    'SURVIVAL'
);

CREATE TYPE proficiency_level_enum AS ENUM (
    'PROFICIENT',
    'EXPERTISE',
    'HALF_PROFICIENT',
    'NOT_PROFICIENT'
);

CREATE TYPE creature_size_enum AS ENUM (
    'TINY',
    'SMALL',
    'MEDIUM',
    'LARGE',
    'HUGE',
    'GARGANTUAN'
);

CREATE TYPE creature_type_enum AS ENUM (
    'ABERRATION',
    'BEAST',
    'CELESTIAL',
    'CONSTRUCT',
    'DRAGON',
    'ELEMENTAL',
    'FEY',
    'FIEND',
    'GIANT',
    'HUMANOID',
    'MONSTROSITY',
    'OOZE',
    'PLANT',
    'UNDEAD',
    'OTHER'
);

CREATE TYPE alignment_enum AS ENUM (
    'LAWFUL_GOOD',
    'NEUTRAL_GOOD',
    'CHAOTIC_GOOD',
    'LAWFUL_NEUTRAL',
    'TRUE_NEUTRAL',
    'CHAOTIC_NEUTRAL',
    'LAWFUL_EVIL',
    'NEUTRAL_EVIL',
    'CHAOTIC_EVIL'
);

CREATE TYPE creature_source_type AS ENUM (
    'MONSTER',
    'CHARACTER',
    'INVOCATION',
    'VEHICLE'
);

CREATE TYPE spell_level_enum AS ENUM (
    'CANTRIP',
    'FIRST',
    'SECOND',
    'THIRD',
    'FOURTH',
    'FIFTH',
    'SIXTH',
    'SEVENTH',
    'EIGHTH',
    'NINTH'
);

CREATE TYPE spell_school_enum AS ENUM (
    'ABJURATION',
    'CONJURATION',
    'DIVINATION',
    'ENCHANTMENT',
    'EVOCATION',
    'ILLUSION',
    'NECROMANCY',
    'TRANSMUTATION',
    'UNIVERSAL'
);

CREATE TYPE casting_time_unit_enum AS ENUM (
    'ACTION',
    'BONUS ACTION',
    'REACTION',
    'MINUTE',
    'HOUR',
    'DAY',
    'TURN'
);

CREATE TYPE range_unit_enum AS ENUM (
    'FEET',
    'SELF',
    'TOUCH',
    'MILES',
    'UNLIMITED'
);

CREATE TYPE duration_unit_enum AS ENUM (
    'ROUNDS',
    'MINUTES',
    'HOURS',
    'DAYS',
    'PERMANENT',
    'INSTANTANEOUS'
);

CREATE TYPE recovery_type_enum AS ENUM (
    'SHORT_REST',
    'LONG_REST',
    'DAILY',
    'PERMANENT',
    'OTHER'
);

CREATE TYPE condition_type_enum AS ENUM (
    'BLINDED',
    'CHARMED',
    'DEAFENED',
    'FRIGHTENED',
    'GRAPPLED',
    'INCAPACITATED',
    'INVISIBLE',
    'PARALYZED',
    'PETRIFIED',
    'POISONED',
    'PRONE',
    'RESTRAINED',
    'STUNNED',
    'UNCONSCIOUS',
    'OTHER'
);

CREATE TYPE action_type_enum AS ENUM (
    'ACTION',
    'BONUS_ACTION',
    'REACTION',
    'LEGENDARY_ACTION',
    'LAIR_ACTION',
    'MYTHIC_ACTION',
    'SPECIAL_ACTION'
);

CREATE TYPE damage_type_enum AS ENUM (
    'ACID',
    'BLUDGEONING',
    'COLD',
    'FIRE',
    'FORCE',
    'LIGHTNING',
    'NECROTIC',
    'PIERCING',
    'POISON',
    'PSYCHIC',
    'RADIANT',
    'SLASHING',
    'THUNDER'
);

CREATE TYPE senses_type_enum AS ENUM (
    'BLINDSIGHT',
    'DARKVISION',
    'TREMORSENSE',
    'TRUESIGHT',
    'OTHER'
);

CREATE TYPE movement_type_enum AS ENUM (
    'WALKING',
    'FLYING',
    'SWIMMING',
    'CLIMBING',
    'BURROWING',
    'OTHER'
);

CREATE TYPE role_enum AS ENUM (
    'DUNGEON_MASTER',
    'PLAYER'
);

CREATE TYPE level_progression_type_enum AS ENUM (
    'CLASS',
    'SUBCLASS',
    'FEAT',
    'BACKGROUND',
    'ITEM',
    'OTHER'
);


CREATE TABLE IF NOT EXISTS users
(
    id             VARCHAR(255) PRIMARY KEY NOT NULL UNIQUE,
    user_image_url TEXT,
    username       VARCHAR(50)  NOT NULL UNIQUE,
    email          VARCHAR(100) NOT NULL UNIQUE,
    created_at     TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS content
(
    id                  UUID PRIMARY KEY             DEFAULT uuid_generate_v4(),
    source_content_enum source_content_enum NOT NULL,
    visibility_enum     visibility_enum     NOT NULL DEFAULT 'PUBLIC',
    created_at          TIMESTAMP WITH TIME ZONE     DEFAULT CURRENT_TIMESTAMP,
    author_id           VARCHAR                NOT NULL REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS items
(
    id                   UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    name                 VARCHAR(255)   NOT NULL,
    description          TEXT,
    item_type_enum       item_type_enum NOT NULL,
    rarity_enum          rarity_enum    NOT NULL DEFAULT 'COMMON',
    weight               DECIMAL(10, 2)          DEFAULT 0.00,
    cost_value           DECIMAL(10, 2)          DEFAULT 0.00 NOT NULL,
    cost_currency        currency_enum  NOT NULL DEFAULT 'GOLD',
    attuntement_required BOOLEAN                 DEFAULT FALSE,
    is_magic             BOOLEAN                 DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS item_tags
(
    id  UUID PRIMARY KEY NOT NULL REFERENCES items (id) ON DELETE CASCADE,
    tag VARCHAR(50)      NOT NULL
);

CREATE TABLE IF NOT EXISTS backgrounds
(
    id          UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    name        VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS classes
(
    id                     UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    name                   VARCHAR(255) NOT NULL,
    description            TEXT,
    hit_dice               VARCHAR(10)  NOT NULL,
    hit_points_first_level INT          NOT NULL DEFAULT 0,
    hit_points_per_level   VARCHAR(10)  NOT NULL DEFAULT '0d0' -- e.g., '1d8'
);

CREATE TABLE IF NOT EXISTS subclasses
(
    id          UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    class_id    UUID         NOT NULL REFERENCES classes (id) ON DELETE CASCADE,
    name        VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS spellcasting
(
    id                            UUID PRIMARY KEY                       DEFAULT uuid_generate_v4(),
    class_id                      UUID                          NOT NULL REFERENCES classes (id) ON DELETE CASCADE,
    spellcasting_progression_enum spellcasting_progression_enum NOT NULL DEFAULT 'FULL_CASTER',
    spellcasting_ability          ability_type_enum             NOT NULL DEFAULT 'INTELLIGENCE',
    preparation_formula           TEXT                                   DEFAULT 'PREPARED'
);

CREATE TABLE IF NOT EXISTS proficiencies
(
    id                    UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    name                  VARCHAR(255)          NOT NULL,
    proficiency_type_enum proficiency_type_enum NOT NULL
);

CREATE TABLE IF NOT EXISTS features
(
    id          UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    is_magic    BOOLEAN DEFAULT FALSE,
    is_passive  BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS special_die
(
    id          UUID PRIMARY KEY     DEFAULT uuid_generate_v4(),
    feature_id  UUID        NOT NULL REFERENCES features (id) ON DELETE CASCADE,
    name        VARCHAR(50) NOT NULL,
    quantity    INT         NOT NULL DEFAULT 1,
    die_formula VARCHAR(10) NOT NULL -- e.g., '1d6'
);

CREATE TABLE IF NOT EXISTS bonuses
(
    id                UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    bonus_type_enum   bonus_type_enum NOT NULL,
    ability_type_enum ability_type_enum,
    skill_type_enum   skill_type_enum,
    dice_formula      VARCHAR(10)     NOT NULL-- e.g., '1d6'
);

CREATE TABLE IF NOT EXISTS abilities
(
    id                UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    ability_type_enum ability_type_enum NOT NULL,
    modifier          INT               NOT NULL DEFAULT 0,
    value             Int               NOT NULL

);

CREATE TABLE IF NOT EXISTS skills
(
    id                     UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    skill_type_enum        skill_type_enum        NOT NULL,
    proficiency_level_enum proficiency_level_enum NOT NULL DEFAULT 'NOT_PROFICIENT'
);

CREATE TABLE IF NOT EXISTS creatures
(
    id                   UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    name                 VARCHAR(255)         NOT NULL,
    size_enum            creature_size_enum   NOT NULL,
    type_enum            creature_type_enum   NOT NULL,
    alignment_enum       alignment_enum       NOT NULL,
    base_hp              INT                  NOT NULL DEFAULT 10,
    base_ac              INT                  NOT NULL DEFAULT 10,
    creature_source_type creature_source_type NOT NULL
);

CREATE TABLE IF NOT EXISTS spells
(
    id                     UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    name                   VARCHAR(255)           NOT NULL,
    description            TEXT,
    spell_components       TEXT                   NOT NULL, -- e.g., 'V, S, M'
    spell_level_enum       spell_level_enum       NOT NULL,
    spell_school_enum      spell_school_enum      NOT NULL,
    casting_time_value     INTEGER                NOT NULL,
    casting_time_unit_enum casting_time_unit_enum NOT NULL,
    range_value            INTEGER                NOT NULL,
    range_unit_enum        range_unit_enum        NOT NULL,
    duration_value         INTEGER                NOT NULL,
    duration_unit_enum     duration_unit_enum     NOT NULL,
    is_ritual              BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS spell_materials
(
    item_id  UUID REFERENCES items (id) ON DELETE CASCADE,
    spell_id UUID REFERENCES spells (id) ON DELETE CASCADE,
    PRIMARY KEY (item_id, spell_id)
);

CREATE TABLE IF NOT EXISTS species
(
    id                 UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    name               VARCHAR(255)       NOT NULL,
    description        TEXT,
    creature_type_enum creature_type_enum NOT NULL,
    languages          TEXT, -- e.g., 'Common, Elvish'
    size_enum          creature_size_enum NOT NULL
);

CREATE TABLE IF NOT EXISTS subspecies
(
    id          UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    species_id  UUID               NOT NULL REFERENCES species (id) ON DELETE CASCADE,
    name        VARCHAR(255)       NOT NULL,
    description TEXT,
    languages   TEXT, -- e.g., 'Common, Elvish',
    size_enum   creature_size_enum NOT NULL
);

CREATE TABLE IF NOT EXISTS feats
(
    id          UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    name        VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS limited_usages
(
    id                    UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    base_max_uses_formula VARCHAR(50)        NOT NULL,              -- e.g., '1d4 + 1'
    is_scaling            BOOLEAN                     DEFAULT FALSE,
    uses                  INTEGER            NOT NULL DEFAULT 0,
    scaling_formula       VARCHAR(50)                 DEFAULT NULL, -- e.g., '1d4 + 1'
    recovery_type_enum    recovery_type_enum NOT NULL
);

CREATE TABLE IF NOT EXISTS effects
(
    id             UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    name           VARCHAR(255)       NOT NULL,
    description    TEXT,
    condition_enum condition_type_enum,
    duration_value INTEGER            NOT NULL,
    duration_unit  duration_unit_enum NOT NULL
);

CREATE TABLE IF NOT EXISTS actions
(
    id                     UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    action_type_enum       action_type_enum NOT NULL,
    attack_formula         VARCHAR(50)       DEFAULT NULL, -- e.g., '1d20 + 5'
    save_ability_type_enum ability_type_enum DEFAULT NULL, -- e.g., 'strength'
    save_dc_formula        VARCHAR(50)       DEFAULT NULL, -- e.g., '8 + proficiency + ability modifier'
    is_rolled              BOOLEAN           DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS damages
(
    id                UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    damage_formula    VARCHAR(50)      NOT NULL,        -- e.g., '1d6 + 3'
    damage_type_enum  damage_type_enum NOT NULL,
    repeat            BOOLEAN            DEFAULT FALSE, -- Whether the damage can be repeated
    repeat_time_value INTEGER            DEFAULT NULL,  -- e.g., 1 for once per turn
    repeat_time_unit  duration_unit_enum DEFAULT NULL   -- e.g., 'turn'
);

CREATE TABLE IF NOT EXISTS senses
(
    id               UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    senses_type_enum senses_type_enum NOT NULL,
    range_value      INTEGER          NOT NULL DEFAULT 0,     -- e.g., 60 for darkvision
    range_unit_enum  range_unit_enum           DEFAULT 'FEET' -- e.g., 'feet'
);

CREATE TABLE IF NOT EXISTS ability_score_improvements
(
    id                UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    ability_type_enum ability_type_enum NOT NULL,
    max_points        INT               NOT NULL DEFAULT 0 -- e.g., +2
);

CREATE TABLE IF NOT EXISTS movements
(
    id                 UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    max_movement_value INTEGER            NOT NULL DEFAULT 30,     -- e.g., 30 feet
    max_movement_unit  range_unit_enum    NOT NULL DEFAULT 'FEET', -- e.g., 'feet'
    movement_type_enum movement_type_enum NOT NULL DEFAULT 'WALKING'
);

CREATE TABLE IF NOT EXISTS rooms
(
    id          UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    name        VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS room_participants
(
    room_id   UUID      NOT NULL REFERENCES rooms (id) ON DELETE CASCADE,
    user_id   VARCHAR      NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    PRIMARY KEY (room_id, user_id),
    role_enum role_enum NOT NULL DEFAULT 'PLAYER'
);

CREATE TABLE IF NOT EXISTS room_creatures
(
    id            UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    creature_id   UUID                 NOT NULL REFERENCES creatures (id) ON DELETE CASCADE,
    owner_id      VARCHAR,
    room_id       UUID,
    creature_type creature_source_type NOT NULL
);

CREATE TABLE IF NOT EXISTS grants
(
    id                 UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    granter_type       source_content_enum NOT NULL,
    granter_content_id UUID                NOT NULL REFERENCES content (id) ON DELETE CASCADE,
    granted_type       source_content_enum NOT NULL,
    granted_content_id UUID                NOT NULL REFERENCES content (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS grant_option_sets
(
    id                 UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    granter_content_id UUID NOT NULL REFERENCES content (id) ON DELETE CASCADE,
    min_choices        INT  NOT NULL    DEFAULT 1,
    max_choices        INT  NOT NULL    DEFAULT 1
);

CREATE TABLE IF NOT EXISTS grant_option_items
(
    granter_option_set_id UUID NOT NULL REFERENCES grant_option_sets (id) ON DELETE CASCADE,
    granted_content_id    UUID NOT NULL REFERENCES content (id) ON DELETE CASCADE,
    PRIMARY KEY (granter_option_set_id, granted_content_id)
);

CREATE TABLE IF NOT EXISTS level_progressions
(
    id                      UUID PRIMARY KEY REFERENCES content (id) ON DELETE CASCADE,
    level                   INT NOT NULL,
    new_special_value       INT         DEFAULT 0,  -- e.g., 1 for new special feature
    new_special_die_formula VARCHAR(10) DEFAULT NULL-- e.g., '1d6' or '1d8'
);

CREATE TABLE IF NOT EXISTS monster
(
    id               UUID PRIMARY KEY REFERENCES creatures (id) ON DELETE CASCADE,
    challenge_rating VARCHAR(50) NOT NULL,  -- e.g., '1/4', '1', '2', etc.
    legendary        BOOLEAN DEFAULT FALSE, -- Whether the monster has legendary actions
    lair             BOOLEAN DEFAULT FALSE  -- Whether the monster has a lair action
);

CREATE TABLE IF NOT EXISTS invocations
(
    id                 UUID PRIMARY KEY REFERENCES creatures (id) ON DELETE CASCADE,
    duration_value     INTEGER            NOT NULL DEFAULT 0, -- e.g., 0 for permanent
    duration_unit_enum duration_unit_enum NOT NULL DEFAULT 'PERMANENT' -- e.g., 'permanent'
);

CREATE TABLE characters
(
    id              UUID PRIMARY KEY REFERENCES creatures (id) ON DELETE CASCADE,
    name            VARCHAR(255),
    alignment       INTEGER,
    age             VARCHAR(255),
    ideals          TEXT,
    personality     TEXT,
    flaws           TEXT,
    biography       TEXT,
    appearance      TEXT,
    height          VARCHAR(50),
    weight          VARCHAR(50),
    skin_color      VARCHAR(100),
    hair_color      VARCHAR(100),
    faith           TEXT,
    eye_color       VARCHAR(100),
    gender          INTEGER
);

CREATE TABLE IF NOT EXISTS chat_messages
(
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    room_id UUID REFERENCES ROOMS (id) ON DELETE CASCADE,
    sender VARCHAR REFERENCES USERS (id),
    content TEXT NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
