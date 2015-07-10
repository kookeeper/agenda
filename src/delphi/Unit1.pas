unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls, RzCmboBx, Mask, RzEdit, RzTabs, RzButton, ComCtrls,
  RzListVw, Planner, PlanItemEdit, PlanSimpleEdit, ExtCtrls, RzPanel,
  DBPlanner, PlannerMonthView, DBPlannerMonthView, DB;

type
  TForm1 = class(TForm)
    RzPageControl1: TRzPageControl;
    TabSheet1: TRzTabSheet;
    tabDia: TRzTabSheet;
    tabMes: TRzTabSheet;
    RzDateTimeEdit1: TRzDateTimeEdit;
    RzDateTimeEdit2: TRzDateTimeEdit;
    RzComboBox1: TRzComboBox;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Label4: TLabel;
    RzDateTimeEdit3: TRzDateTimeEdit;
    Label5: TLabel;
    RzEdit1: TRzEdit;
    RzBitBtn1: TRzBitBtn;
    RzBitBtn2: TRzBitBtn;
    RzBitBtn3: TRzBitBtn;
    SimpleItemEditor1: TSimpleItemEditor;
    DBPlannerMonthView1: TDBPlannerMonthView;
    DBMonthSource1: TDBMonthSource;
    DataSource1: TDataSource;
    DBPlanner1: TDBPlanner;
    RzPanel1: TRzPanel;
    RzBitBtn4: TRzBitBtn;
    RzPanel2: TRzPanel;
    RzBitBtn5: TRzBitBtn;
    DBDaySource1: TDBDaySource;
    procedure DefaultItemEditor1BeforeEditShow(Sender: TObject;
      APlannerItem: TPlannerItem);
    procedure RzBitBtn4Click(Sender: TObject);
    procedure RzBitBtn5Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

uses Unit2;

{$R *.dfm}

procedure TForm1.DefaultItemEditor1BeforeEditShow(Sender: TObject;
  APlannerItem: TPlannerItem);
begin
  SimpleItemEditor1.Caption := 'Edit item : ' + APlannerItem.ItemSpanTimeStr;
end;

procedure TForm1.RzBitBtn4Click(Sender: TObject);
begin
  with DBPlanner1.CreateItem do
  begin
    itemBegin := DBPlanner1.SelItemBegin;
    itemEnd := DBPlanner1.SelItemEnd;
    itemPos := DBPlanner1.SelPosition;
    Edit;
    Text.Add('teste');
  end;
end;

procedure TForm1.RzBitBtn5Click(Sender: TObject);
begin
  RzPageControl1.TabIndex := tabDia.TabIndex;
end;

end.
