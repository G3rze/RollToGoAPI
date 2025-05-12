import { Table, Column, Model, DataType, ForeignKey, BelongsTo } from 'sequelize-typescript';
import Content from './Content.model';

@Table({ tableName: 'recommended_path', timestamps: false, underscored: true })
export class RecommendedPath extends Model {
    @Column({
        type: DataType.UUID,
        primaryKey: true,
        defaultValue: DataType.UUIDV4
    })
    id!: string;

    @ForeignKey(() => Content)
    @Column({ type: DataType.UUID, field: 'character_id', allowNull: false })
    character_id!: string;

    @Column({ type: DataType.JSONB, allowNull: false })
    preselected_features!: object;

    @BelongsTo(() => Content, 'character_id')
    character!: Content;
}

export default RecommendedPath;