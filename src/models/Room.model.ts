import { Table, Column, Model, DataType, ForeignKey, BelongsTo, HasMany } from 'sequelize-typescript';
import User from './User.model';
import RoomParticipant from './RoomParticipant.model';
import RoomChat from "./RoomChat.model";
import RoomEntity from "./RoomEntity.model";

@Table({ tableName: 'room', timestamps: false, underscored: true })
export class Room extends Model {
    @Column({
        type: DataType.UUID,
        primaryKey: true,
        defaultValue: DataType.UUIDV4
    })
    id!: string;

    @ForeignKey(() => User)
    @Column({ type: DataType.UUID, field: 'owner_id', allowNull: false })
    owner_id!: string;

    @ForeignKey(() => User)
    @Column({ type: DataType.UUID, field: 'current_dm_id', allowNull: false })
    current_dm_id!: string;

    @Column({ type: DataType.JSONB, allowNull: false })
    scene_state!: object;

    @Column({ type: DataType.BOOLEAN, defaultValue: false })
    visibility!: boolean;

    @BelongsTo(() => User, 'owner_id')
    owner!: User;

    @BelongsTo(() => User, 'current_dm_id')
    currentDm!: User;

    @HasMany(() => RoomParticipant)
    participants!: RoomParticipant[];

    @HasMany(() => RoomChat)
    chats!: RoomChat[];

    @HasMany(() => RoomEntity)
    entities!: RoomEntity[]
}

export default Room;