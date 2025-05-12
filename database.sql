--Add UUID Extenstion
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

--Tables
CREATE TABLE users (
                       id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
                       firebase_uid TEXT UNIQUE NOT NULL,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE content (
                         id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
                         type VARCHAR(20) NOT NULL
                             CHECK (
                                 type IN (
                                          'character',
                                          'class',
                                          'subclass',
                                          'feature',
                                          'spell',
                                          'effect',
                                          'item',
                                          'race',
                                          'background',
                                          'monster'
                                     )
                                 ),
                         original_owner_id UUID NOT NULL,
                         current_owner_id UUID NOT NULL,
                         data JSONB NOT NULL,
                         is_homebrew BOOLEAN NOT NULL,
                         dependencies JSONB NOT NULL,
                         visibility BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE content_subscription (
                                     id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
                                     user_id UUID NOT NULL,
                                     content_id UUID NOT NULL
);

CREATE TABLE recommended_path (
                                  id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
                                  character_id UUID NOT NULL,
                                  preselected_features JSONB NOT NULL
);


CREATE TABLE room (
                      id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
                      owner_id UUID NOT NULL,
                      current_dm_id UUID NOT NULL,
                      scene_state JSONB NOT NULL,
                      visibility BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE room_participants (
                                ID UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
                                user_id UUID NOT NULL,
                                room_id UUID NOT NULL,
                                role VARCHAR(20) NOT NULL
                                    CHECK (
                                        role IN (
                                                    'player',
                                                    'dm'
                                               )
                                           )
);

CREATE TABLE character_level_progression (
                                             id UUID DEFAULT uuid_generate_v4() PRIMARY KEY ,
                                             character_id UUID NOT NULL,
                                             user_id UUID NOT NULL,
                                             selected_features JSONB NOT NULL
);

CREATE TABLE room_chat (
                           id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
                           room_id UUID NOT NULL,
                           room_participant_id UUID NOT NULL,
                           data JSONB NOT NULL
);

CREATE TABLE room_entity (
                             id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
                             room_id UUID NOT NULL,
                             participant_id UUID NOT NULL,
                             content_id UUID NOT NULL,
                             state JSONB NOT NULL
);

--RELATIONS

-- content_subscription
ALTER TABLE content_subscription
    ADD CONSTRAINT fk_content_subscription_user
        FOREIGN KEY (user_id)
            REFERENCES users(id)
            ON DELETE CASCADE;

ALTER TABLE content_subscription
    ADD CONSTRAINT fk_content_subscription_content
        FOREIGN KEY (content_id)
            REFERENCES content(id)
            ON DELETE CASCADE;

--character_level
ALTER TABLE character_level_progression
    ADD CONSTRAINT fk_character_level_progression_character
        FOREIGN KEY (character_id)
            REFERENCES content(id)
            ON DELETE CASCADE;

ALTER TABLE character_level_progression
    ADD CONSTRAINT fk_character_progression_user
        FOREIGN KEY (user_id)
            REFERENCES users(id)
            ON DELETE CASCADE;

--room_participants
ALTER TABLE room_participants
    ADD CONSTRAINT fk_room_participants_user
        FOREIGN KEY (user_id)
            REFERENCES users(id)
            ON DELETE CASCADE;

ALTER TABLE room_participants
    ADD CONSTRAINT fk_room_participants_room
        FOREIGN KEY (room_id)
            REFERENCES room(id)
            ON DELETE CASCADE;

--content
ALTER TABLE content
    ADD CONSTRAINT fk_content_original_owner_id
        FOREIGN KEY (original_owner_id)
            REFERENCES users(id);

ALTER TABLE content
    ADD CONSTRAINT fk_content_current_owner_id
        FOREIGN KEY (current_owner_id)
            REFERENCES users(id)
            ON DELETE CASCADE;

--recommended_path
ALTER TABLE recommended_path
    ADD CONSTRAINT fk_recommended_path_character
        FOREIGN KEY (character_id)
            REFERENCES users(id)
            ON DELETE CASCADE;

--room_chat
ALTER TABLE room_chat
    ADD CONSTRAINT fk_room_chat_room_participant
        FOREIGN KEY (room_participant_id)
            REFERENCES room_participants(id)
            ON DELETE CASCADE;

ALTER TABLE room_chat
    ADD CONSTRAINT fk_room_chat_room
        FOREIGN KEY (room_id)
            REFERENCES room(id)
            ON DELETE CASCADE;

--room
ALTER TABLE room
    ADD CONSTRAINT fk_room_owner
        FOREIGN KEY (owner_id)
            REFERENCES users(id)
            ON DELETE CASCADE;

ALTER TABLE room
    ADD CONSTRAINT fk_room_current_dm
        FOREIGN KEY (current_dm_id)
            REFERENCES users(id)
            ON DELETE CASCADE;

--room_entity
ALTER TABLE room_entity
    ADD CONSTRAINT fk_room_entity_participant
        FOREIGN KEY (participant_id)
            REFERENCES room_participants(id)
            ON DELETE CASCADE;

ALTER TABLE room_entity
    ADD CONSTRAINT fk_room_entity_content
        FOREIGN KEY (content_id)
            REFERENCES content(id)
            ON DELETE CASCADE;