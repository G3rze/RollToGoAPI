import { Table, Column, Model, DataType, ForeignKey, BelongsTo } from 'sequelize-typescript';
import Content from './Content.model';
import User from './User.model';

@Table({ tableName: 'character_level_progression', timestamps: false, underscored: true })
export class CharacterLevelProgression extends Model {
    @Column({
        type: DataType.UUID,
        primaryKey: true,
        defaultValue: DataType.UUIDV4
    })
    id!: string;

    @ForeignKey(() => Content)
    @Column({ type: DataType.UUID, field: 'character_id', allowNull: false })
    character_id!: string;

    @ForeignKey(() => User)
    @Column({ type: DataType.UUID, field: 'user_id', allowNull: false })
    user_id!: string;

    @Column({ type: DataType.JSONB, allowNull: false })
    selected_features!: object;

    @BelongsTo(() => Content, 'character_id')
    character!: Content;

    @BelongsTo(() => User)
    user!: User;
}

export default CharacterLevelProgression;