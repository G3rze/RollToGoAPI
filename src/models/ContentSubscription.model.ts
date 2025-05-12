import { Table, Column, Model, DataType, ForeignKey, BelongsTo } from 'sequelize-typescript';
import User from './User.model';
import Content from './Content.model';

@Table({ tableName: 'content_subscription', timestamps: false, underscored: true })
export class ContentSubscription extends Model {
    @Column({
        type: DataType.UUID,
        primaryKey: true,
        defaultValue: DataType.UUIDV4
    })
    id!: string;

    @ForeignKey(() => User)
    @Column({ type: DataType.UUID, field: 'user_id', allowNull: false })
    user_id!: string;

    @ForeignKey(() => Content)
    @Column({ type: DataType.UUID, field: 'content_id', allowNull: false })
    content_id!: string;

    @BelongsTo(() => User)
    user!: User;

    @BelongsTo(() => Content)
    content!: Content;
}

export default ContentSubscription;