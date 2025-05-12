import { Table, Column, Model, DataType, ForeignKey, BelongsTo } from 'sequelize-typescript';
import Room from './Room.model';
import RoomParticipant from './RoomParticipant.model';
import Content from './Content.model';

@Table({ tableName: 'room_entity', timestamps: false, underscored: true })
export class RoomEntity extends Model {
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
    @Column({ type: DataType.UUID, field: 'participant_id', allowNull: false })
    participant_id!: string;

    @ForeignKey(() => Content)
    @Column({ type: DataType.UUID, field: 'content_id', allowNull: false })
    content_id!: string;

    @Column({ type: DataType.JSONB, allowNull: false })
    state!: object;

    @BelongsTo(() => Room)
    room!: Room;

    @BelongsTo(() => RoomParticipant)
    participant!: RoomParticipant;

    @BelongsTo(() => Content)
    content!: Content;
}

export default RoomEntity;