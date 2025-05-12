import { Table, Column, Model, DataType, ForeignKey, BelongsTo } from 'sequelize-typescript';
import User from './User.model';
import Room from './Room.model';

enum Role {
    PLAYER = 'player',
    DM = 'dm'
}

@Table({ tableName: 'room_participants', timestamps: false, underscored: true })
export class RoomParticipant extends Model {
    @Column({
        type: DataType.UUID,
        primaryKey: true,
        defaultValue: DataType.UUIDV4
    })
    id!: string;

    @ForeignKey(() => User)
    @Column({ type: DataType.UUID, field: 'user_id', allowNull: false })
    user_id!: string;

    @ForeignKey(() => Room)
    @Column({ type: DataType.UUID, field: 'room_id', allowNull: false })
    room_id!: string;

    @Column({ type: DataType.ENUM(...Object.values(Role)), allowNull: false })
    role!: Role;

    @BelongsTo(() => User)
    user!: User;

    @BelongsTo(() => Room)
    room!: Room;
}

export default RoomParticipant;