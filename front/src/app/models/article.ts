export interface Article{
    id: number;
    imageUrl: string;
    likes: number;
    title: string;
    content: string;
    isApproved: boolean;
    createdAt: string;
    readCount: string;
}

export interface PagesArticle{
    content: Article[];
    pageable: Page;
    totalPages: number;
    totalElements: number;
    size: number;
}
export interface Page{
    pageNumber: number;
    pageSize:number;
    
}