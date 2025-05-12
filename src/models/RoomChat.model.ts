import { Table, Column, Model, DataType, ForeignKey, BelongsTo } from 'sequelize-typescript';
import Room from './Room.model';
import RoomParticipant from './RoomParticipant.model';

@Table({ tableName: 'room_chat', timestamps: false, underscored: true })
export class RoomChat extends Model {
    @Column({
        type: DataType.UUID,
        primaryKey: true,
        defaultValue: DataType.UUIDV4
    })
    id!: string;

    @ForeignKey(() => Room)
    @Column({ type: DataType.UUID, field: 'room_id', allowNull: false })
    room_id!: string;

    @ForeignKey(() => RoomParticipant)
    @Column({ type: DataType.UUID, field: 'room_participant_id', allowNull: false })
    room_participant_id!: string;

    @Column({ type: DataType.JSONB, allowNull: false })
    data!: object;

    @BelongsTo(() => Room)
    room!: Room;

    @BelongsTo(() => RoomParticipant)
    participant!: RoomParticipant;
}

export default RoomChat;