import {
    Table, Column, Model, DataType, HasMany
} from 'sequelize-typescript';
import Content from './Content.model';
import RoomParticipant from './RoomParticipant.model';
import CharacterLevelProgression from "./CharacterLevelProgression.model";

@Table({ tableName: 'users', timestamps: false, underscored: true })
export class User extends Model {
    @Column({
        type: DataType.UUID,
        primaryKey: true,
        defaultValue: DataType.UUIDV4
    })
    id!: string;

    @Column({ type: DataType.TEXT, unique: true, allowNull: false })
    firebase_uid!: string;

    @Column({ type: DataType.STRING(50), unique: true, allowNull: false })
    username!: string;

    @Column({
        type: DataType.DATE,
        defaultValue: DataType.NOW,
        field: 'created_at'
    })
    created_at!: Date;

    @HasMany(() => Content, 'original_owner_id')
    originalContents!: Content[];

    @HasMany(() => Content, 'current_owner_id')
    currentContents!: Content[];

    @HasMany(() => RoomParticipant)
    roomParticipants!: RoomParticipant[];

    @HasMany(() => require('./CharacterLevelProgression.model').CharacterLevelProgression)
    levelProgressions!: CharacterLevelProgression[];
}

export default User;